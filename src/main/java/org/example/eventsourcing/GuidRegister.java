package org.example.eventsourcing;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;

@Component
public class GuidRegister {
    public Guid register(String guid) {
        reserve(guid);
        return new Guid(guid);
    }

    public Guid verify(String guid) {
        // I guess see if this is a real guid?
        return new Guid(checkNotNull(guid));
    }

    private void reserve(String guid) {
        // TODO
    }
}
