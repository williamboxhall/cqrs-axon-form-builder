package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.domain.PersonProfile;

public class PersonProfileQuery implements Query<PersonProfile> {
    private String personId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
