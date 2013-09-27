package org.example.write.commands;

import java.util.Map;

import org.example.eventsourcing.domain.Command;

public class SubmitForm implements Command {
    private Map<String, String> fields;

    public Map<String, String> getFields() {
        return fields;
    }

    public void setFields(Map<String, String> fields) {
        this.fields = fields;
    }
}
