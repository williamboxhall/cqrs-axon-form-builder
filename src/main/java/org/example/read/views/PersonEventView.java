package org.example.read.views;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

@Entity
public class PersonEventView {
    @Id
    private UUID id;
    private final String personId;
    private final String eventType;
    @Temporal(TIMESTAMP)
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

    public String getEventDate() {
        return new SimpleDateFormat("dd/MM/yyyy").format(eventDate);
    }
}
