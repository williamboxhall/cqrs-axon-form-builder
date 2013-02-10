package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.domain.PersonProfile;
import org.example.read.domain.PersonProfileView;

public class PersonProfileQuery implements Query<PersonProfile> {
    private String guid;

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
