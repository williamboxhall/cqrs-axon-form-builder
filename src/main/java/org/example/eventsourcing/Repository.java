package org.example.eventsourcing;

public interface Repository<T extends AggregateRoot> {
    void save(T aggregateRoot);

    T getById(Guid guid);
}
