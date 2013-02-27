package org.example.read.views;

import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonEventView {
    @Id
    private UUID id;
    private final String personId;
    private final String eventType;
    private final Date eventDate;

    protected PersonEventView() {
        this.personId = null;
        this.eventType = null;
        this.eventDate = null;
    }

    public PersonEventView(UUID id, String personId, String eventType, Date eventDate) {
        this.id = id;
        this.personId = personId;
        this.eventType = eventType;
        this.eventDate = eventDate;
    }

    public String getPersonId() {
        return personId;
    }

    public String getEventType() {
        return eventType;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
