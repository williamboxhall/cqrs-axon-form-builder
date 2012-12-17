package org.example.eventsourcing;

import org.springframework.stereotype.Component;

@Component
public class EventBasedRepository<T extends AggregateRoot> implements Repository<T> {
    @Override
    public void save(T aggregateRoot) {
        System.out.println("saved " + aggregateRoot);
    }
}
