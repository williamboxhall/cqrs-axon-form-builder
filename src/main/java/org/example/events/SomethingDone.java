package org.example.events;

import org.example.eventsourcing.domain.Event;

public class SomethingDone extends Event {
    private final String personId;
    private final String done;

    public SomethingDone(String personId, String done) {
        this.personId = personId;
        this.done = done;
    }

    public String getPersonId() {
        return personId;
    }

    public String getDone() {
        return done;
    }
}
