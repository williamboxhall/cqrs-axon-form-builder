package org.example.eventsourcing;

import static java.lang.String.format;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EventStore {
    public void saveEvents(Guid guid, List<Event> events) {
        System.out.println(format("Saved %s %s", guid, events));
    }
}
