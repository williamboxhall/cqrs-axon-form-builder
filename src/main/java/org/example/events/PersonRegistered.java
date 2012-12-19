package org.example.events;

import org.example.eventsourcing.domain.Event;
import org.example.eventsourcing.domain.Guid;
import org.example.write.domain.PersonalInformation;

public class PersonRegistered extends Event {
    private final Guid guid;
    private final PersonalInformation personalInformation;

    public PersonRegistered(Guid guid, PersonalInformation personalInformation) {
        this.guid = guid;
        this.personalInformation = personalInformation;
    }

    public Guid getGuid() {
        return guid;
    }

    public PersonalInformation getPersonalInformation() {
        return personalInformation;
    }
}
