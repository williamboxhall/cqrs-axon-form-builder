package org.example.eventsourcing.infrastructure;

import static com.google.common.base.CaseFormat.LOWER_CAMEL;
import static com.google.common.base.CaseFormat.UPPER_CAMEL;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandlerFactoryBean;
import org.axonframework.commandhandling.annotation.AnnotationCommandTargetResolver;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventstore.EventStore;
import org.hibernate.MappingException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AssignableTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.ClassUtils;

public class CommandHandlerAnnotatedAggregateRootScanner implements InitializingBean, ApplicationContextAware {
	private static final String RESOURCE_PATTERN = "**/*.class";
	private EventStore eventStore;
	private EventBus eventBus;
	private CommandBus commandBus;
	private ApplicationContext applicationContext;
	private String[] packagesToScan;
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	private TypeFilter[] entityTypeFilters = new TypeFilter[]{
			new AssignableTypeFilter(AbstractAnnotatedAggregateRoot.class)};

	@Override
	public void afterPropertiesSet() throws Exception {
		Set<Class> aggregateTypes = scanPackages();
		for (Class aggregateType : aggregateTypes) {
			AggregateAnnotationCommandHandlerFactoryBean factory = new AggregateAnnotationCommandHandlerFactoryBean();
			factory.setAggregateType(aggregateType);
			factory.setCommandBus(commandBus);
			EventSourcingRepository repository = new EventSourcingRepository(aggregateType, eventStore);
			repository.setEventBus(eventBus);
			factory.setRepository(repository);
			factory.setApplicationContext(applicationContext);
			factory.afterPropertiesSet();
		}
	}


	/**
	 * Set whether to use Spring-based scanning for entity classes in the
	 * classpath instead of listing annotated classes explicitly.
	 * <p/>
	 * <p/>
	 * <p/>
	 * Default is none. Specify packages to search for autodetection of your
	 * entity classes in the classpath. This is analogous to
	 * <p/>
	 * Spring's component-scan feature
	 * (org.springframework.context.annotation.ClassPathBeanDefinitionScanner}).
	 */

	public void setPackagesToScan(String[] packagesToScan) {
		this.packagesToScan = packagesToScan;
	}

	/**
	 * Perform Spring-based scanning for entity classes.
	 *
	 * @see #setPackagesToScan
	 */

	protected Set<Class> scanPackages() {
		Set<Class> entities = new HashSet<Class>();
		if (this.packagesToScan != null) {
			try {
				for (String pkg : this.packagesToScan) {
					String pattern = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX
							+ ClassUtils.convertClassNameToResourcePath(pkg)
							+ RESOURCE_PATTERN;
					Resource[] resources = this.resourcePatternResolver
							.getResources(pattern);
					MetadataReaderFactory readerFactory = new CachingMetadataReaderFactory(
							this.resourcePatternResolver);
					for (Resource resource : resources) {
						if (resource.isReadable()) {
							MetadataReader reader = readerFactory
									.getMetadataReader(resource);
							if (matchesFilter(reader, readerFactory) && !reader.getClassMetadata().isAbstract()) {
								entities.add(Class.forName(reader.getClassMetadata().getClassName()));
							}
						}
					}
				}
			} catch (Exception ex) {
				throw new MappingException(
						"Failed to scan classpath for unlisted classes", ex);
			}
		}
		return entities;
	}

	/**
	 * Check whether any of the configured entity type filters matches the
	 * current class descriptor contained in the metadata
	 * <p/>
	 * reader.
	 */
	private boolean matchesFilter(MetadataReader reader,
								  MetadataReaderFactory readerFactory) throws IOException {
		if (this.entityTypeFilters != null) {
			for (TypeFilter filter : this.entityTypeFilters) {
				if (filter.match(reader, readerFactory)) {
					return true;
				}
			}
		}
		return false;
	}

	public void setEventStore(org.axonframework.eventstore.EventStore eventStore) {
		this.eventStore = eventStore;
	}

	public void setCommandBus(CommandBus commandBus) {
		this.commandBus = commandBus;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}
}

