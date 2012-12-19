package org.example.write.domain;

import org.example.eventsourcing.domain.EventBasedRepository;
import org.example.eventsourcing.infrastructure.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository extends EventBasedRepository<Person> {
    @Autowired
    public PersonRepository(EventStore eventStore) {
        super(eventStore);
    }
}
