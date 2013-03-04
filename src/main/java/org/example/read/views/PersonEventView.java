package org.example.read.views;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

@Entity
public class PersonEventView {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id", unique = true)
    private UUID id;
    private final String personId;
    private final String eventType;
    @Column
    @Type(type = "org.joda.time.contrib.hibernate.PersistentDateTime")
    private final DateTime eventDate;

    protected PersonEventView() {
        this.personId = null;
        this.eventType = null;
        this.eventDate = null;
    }

    public PersonEventView(String personId, String eventType, DateTime eventDate) {
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
        return eventDate.toString("dd/MM/yyyy");
    }
}
