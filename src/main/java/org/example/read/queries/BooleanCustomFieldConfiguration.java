package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.BooleanCustomFieldConfigurationDto;

public class BooleanCustomFieldConfiguration implements Query<BooleanCustomFieldConfigurationDto> {
    private String booleanCustomFieldGuid;

    public String getBooleanCustomFieldGuid() {
        return booleanCustomFieldGuid;
    }

    public void setBooleanCustomFieldGuid(String booleanCustomFieldGuid) {
        this.booleanCustomFieldGuid = booleanCustomFieldGuid;
    }
}
