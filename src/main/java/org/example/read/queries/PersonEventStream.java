package org.example.read.queries;

import java.util.List;

import org.example.eventsourcing.domain.Query;
import org.example.read.views.PersonEventView;

public class PersonEventStream implements Query<List<PersonEventView>> {
    private String personId;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
