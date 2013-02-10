package org.example.eventsourcing.domain;

import static org.example.eventsourcing.infrastructure.Reflections.secondGenericTypeFromInterfaceOnClass;

import java.util.Map;

import com.google.common.collect.Maps;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class QueryHandlerRepository implements BeanPostProcessor {
    private Map<Class<Query>, QueryHandler> handlers = Maps.newHashMap();

    public <T, Q extends Query<T>> QueryHandler<T, Q> handlerFor(Class<Query> type) {
        return handlers.get(type);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (QueryHandler.class.isAssignableFrom(bean.getClass())) {
            QueryHandler queryHandler = (QueryHandler) bean;
            handlers.put(queryTypeFrom(queryHandler), queryHandler);
        }
        return bean;
    }

    private Class<Query> queryTypeFrom(QueryHandler queryHandler) {
        return (Class<Query>) secondGenericTypeFromInterfaceOnClass(QueryHandler.class, queryHandler.getClass());
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}

