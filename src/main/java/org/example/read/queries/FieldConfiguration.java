package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.FieldConfigurationDto;

public abstract class FieldConfiguration<T extends FieldConfigurationDto> implements Query<T> {
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
