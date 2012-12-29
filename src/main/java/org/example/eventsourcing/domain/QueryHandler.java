package org.example.eventsourcing.domain;

public interface QueryHandler<T, Q extends Query<T>> {
    T handle(Q query);
}
