package org.example.write.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import org.example.events.PersonRegistered;
import org.example.eventsourcing.AggregateRoot;
import org.example.eventsourcing.Guid;

public class Person extends AggregateRoot {
    private Guid guid;
    private PersonalInformation personalInformation;

    private void apply(PersonRegistered personRegistered) {
        this.guid = personRegistered.getGuid();
        this.personalInformation = personRegistered.getPersonalInformation();
    }

    public static Person register(Guid guid, PersonalInformation personalInformation) {
        Person person = new Person();
        person.apply(new PersonRegistered(checkNotNull(guid), checkNotNull(personalInformation)));
        return person;
    }

    private Person() {
    }
}
