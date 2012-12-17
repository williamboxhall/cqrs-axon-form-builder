package org.example.write.domain;

import org.example.eventsourcing.EventBasedRepository;
import org.example.eventsourcing.EventStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonRepository extends EventBasedRepository<Person> {
    @Autowired
    public PersonRepository(EventStore eventStore) {
        super(eventStore);
    }
}
