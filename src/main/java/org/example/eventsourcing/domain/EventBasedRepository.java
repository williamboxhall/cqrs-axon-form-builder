package org.example.eventsourcing.domain;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.example.eventsourcing.infrastructure.EventStore;

public abstract class EventBasedRepository<T extends AggregateRoot> implements Repository<T> {
    private final EventStore eventStore;
    private final Class aggregateType;

    public EventBasedRepository(EventStore eventStore) {
        this.eventStore = eventStore;
        this.aggregateType = aggregateType();
    }

    @Override
    public void save(T aggregateRoot) {
        // potentially decorate with meta (application name, timestamps etc.) here
        eventStore.saveEvents(aggregateRoot.getGuid(), aggregateRoot.getChanges());
    }

    @Override
    public T getById(Guid guid) {
        T aggregateRoot = createAggregateRootViaReflection(guid);
        aggregateRoot.loadFromHistory(eventStore.getEvents(guid));
        return aggregateRoot;
    }

    private T createAggregateRootViaReflection(Guid guid) {
        Constructor[] cons = aggregateType.getDeclaredConstructors();
        cons[0].setAccessible(true);
        try {
            return (T) cons[0].newInstance(guid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Class aggregateType() {
        Type genType = getClass().getGenericSuperclass();
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

            if ((params != null) && (params.length >= 1)) {
                return (Class) params[0];
            }
        }
        return null;
    }
}
