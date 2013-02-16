package org.example.read.queries;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.PersonProfileView;

public class JustInTimePersonProfileQuery implements Query<PersonProfileView> {
    private String personId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
