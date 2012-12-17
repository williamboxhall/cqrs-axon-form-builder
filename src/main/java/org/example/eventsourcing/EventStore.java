package org.example.eventsourcing;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import org.springframework.stereotype.Component;

@Component
public class EventStore {
    private final ArrayListMultimap<Guid, Event> store = ArrayListMultimap.create();

    public void saveEvents(Guid guid, List<Event> events) {
        store.get(guid).addAll(events);
    }

    public List<Event> getEvents(Guid guid) {
        return store.get(guid);
    }
}
