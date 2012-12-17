package org.example.events;

import org.example.eventsourcing.Event;
import org.example.write.domain.Gender;

public class SexChanged extends Event {
    private final Gender gender;

    public SexChanged(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
