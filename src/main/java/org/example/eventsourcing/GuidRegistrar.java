package org.example.eventsourcing;

import org.springframework.stereotype.Component;

@Component
public class GuidRegistrar {
    public Guid register(String guid) {
        reserve(guid);
        return new Guid(guid);
    }

    private void reserve(String guid) {
        // TODO
    }
}
