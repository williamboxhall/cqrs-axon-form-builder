package org.example.eventsourcing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventBasedRepository<T extends AggregateRoot> implements Repository<T> {
    private final EventStore eventStore;

    @Autowired
    public EventBasedRepository(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public void save(T aggregateRoot) {
        eventStore.saveEvents(aggregateRoot.getGuid(), aggregateRoot.getChanges());
    }

    @Override
    public T getById(Guid guid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
