package org.example.write.domain;

import org.axonframework.eventsourcing.AggregateFactory;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventstore.EventStore;
import org.axonframework.repository.LockManager;

// TODO this class should not need to exist but axon fails to autowire it in without a concrete type
public class FieldRepository extends EventSourcingRepository<Field> {
    public FieldRepository(Class aggregateType, EventStore eventStore) {
        super(aggregateType, eventStore);
    }

    public FieldRepository(AggregateFactory aggregateFactory, EventStore eventStore) {
        super(aggregateFactory, eventStore);
    }

    public FieldRepository(AggregateFactory aggregateFactory, EventStore eventStore, LockManager lockManager) {
        super(aggregateFactory, eventStore, lockManager);
    }

    public FieldRepository(Class aggregateType, EventStore eventStore, LockManager lockManager) {
        super(aggregateType, eventStore, lockManager);
    }

    public FieldRepository(Class aggregateType) {
        super(aggregateType);
    }

    public FieldRepository(AggregateFactory aggregateFactory) {
        super(aggregateFactory);
    }

    public FieldRepository(AggregateFactory aggregateFactory, LockManager lockManager) {
        super(aggregateFactory, lockManager);
    }

    public FieldRepository(Class aggregateType, LockManager lockManager) {
        super(aggregateType, lockManager);
    }
}
