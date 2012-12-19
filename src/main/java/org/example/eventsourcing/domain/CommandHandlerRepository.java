package org.example.eventsourcing.domain;

import static org.example.eventsourcing.infrastructure.Reflections.firstGenericTypeFrom;

import java.util.Map;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CommandHandlerRepository implements BeanPostProcessor {
    private final BeanFactory beanFactory;
    private Map<Class<Command>, CommandHandler> handlers = Maps.newHashMap();

    @Autowired
    public CommandHandlerRepository(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public <T extends Command> CommandHandler<T> handlerFor(Class<Command> command) {
        return handlers.get(command);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (CommandHandler.class.isAssignableFrom(bean.getClass())) {
            CommandHandler commandHandler = (CommandHandler) bean;
            handlers.put(commandTypeFrom(commandHandler), commandHandler);
        }
        return bean;
    }

    private Class<Command> commandTypeFrom(CommandHandler commandHandler) {
        return (Class<Command>) firstGenericTypeFrom(commandHandler.getClass());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
