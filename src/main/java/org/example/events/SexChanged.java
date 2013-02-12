package org.example.events;

import org.example.eventsourcing.domain.Event;

public class SexChanged extends Event {
    private final String personId;
    private final String gender;

    public SexChanged(String personId, String gender) {
        this.personId = personId;
        this.gender = gender;
    }

    public String getPersonId() {
        return personId;
    }

    public String getGender() {
        return gender;
    }
}
