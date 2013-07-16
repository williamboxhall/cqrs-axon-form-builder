package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.BooleanCustomFieldConigurationDto;

public class BooleanCustomFieldConfiguration implements Query<BooleanCustomFieldConigurationDto> {
    private String booleanCustomFieldGuid;

    public String getBooleanCustomFieldGuid() {
        return booleanCustomFieldGuid;
    }

    public void setBooleanCustomFieldGuid(String booleanCustomFieldGuid) {
        this.booleanCustomFieldGuid = booleanCustomFieldGuid;
    }
}
