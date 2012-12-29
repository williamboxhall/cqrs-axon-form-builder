package org.example.read.application;

import org.example.eventsourcing.domain.Query;
import org.example.read.domain.PersonProfileView;

public class PersonProfileQuery implements Query<PersonProfileView> {
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
