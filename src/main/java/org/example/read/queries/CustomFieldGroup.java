package org.example.read.queries;

import java.util.List;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.CustomFieldConfigurationDto;

public class CustomFieldGroup implements Query<List<CustomFieldConfigurationDto>> {
    private String context;

    public CustomFieldGroup() {
    }

    public CustomFieldGroup(String context) {
        this.context = context;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
