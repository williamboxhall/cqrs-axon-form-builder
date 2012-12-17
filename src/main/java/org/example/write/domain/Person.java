package org.example.write.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.eventsourcing.AggregateRoot;
import org.example.eventsourcing.Guid;

public class Person extends AggregateRoot {
    private Guid guid;
    private PersonalInformation personalInformation;

    private void apply(PersonRegistered personRegistered) {
        this.guid = personRegistered.getGuid();
        this.personalInformation = personRegistered.getPersonalInformation();
    }

    private void apply(SexChanged sexChanged) {
        this.personalInformation.setGender(sexChanged.getGender());
    }

    public static Person register(Guid guid, PersonalInformation personalInformation) {
        Person person = new Person();
        person.applyChange(new PersonRegistered(checkNotNull(guid), checkNotNull(personalInformation)));
        return person;
    }

    public void changeSex(Gender gender) {
        if (this.personalInformation.getGender().equals(gender)) {
            throw new IllegalArgumentException("Gender has not changed!");
        }
        applyChange(new SexChanged(gender));
    }

    @Override
    public Guid getGuid() {
        return guid;
    }

    private Person() {
    }
}
