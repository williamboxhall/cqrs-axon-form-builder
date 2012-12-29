package org.example.events;

import org.example.eventsourcing.domain.Event;

public class SexChanged extends Event {
    private final String gender;

    public SexChanged(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
