package org.example.eventsourcing.domain;

public interface Repository<T extends AggregateRoot> {
    void save(T aggregateRoot);

    T getById(Guid guid);
}
