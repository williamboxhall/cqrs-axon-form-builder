package org.example.events;

import static com.google.common.collect.ImmutableMap.copyOf;

import java.util.Map;
import java.util.UUID;

public class FormSubmitted {
    private final Map<String, String> fieldSubmissions;
    private final UUID guid;

    public FormSubmitted(UUID guid, Map<String, String> fieldSubmissions) {
        this.guid = guid;
        this.fieldSubmissions = copyOf(fieldSubmissions);
    }

    public Map<String, String> getFieldSubmissions() {
        return copyOf(fieldSubmissions);
    }

    public UUID getGuid() {
        return guid;
    }
}
