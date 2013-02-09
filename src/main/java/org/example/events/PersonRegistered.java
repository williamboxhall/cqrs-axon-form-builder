package org.example.events;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Event;

public class PersonRegistered extends Event {
    private final String guid;
    private final String title;
    private final String firstName;
    private final String lastName;
    private final String birthday;
    private final String gender;

    public PersonRegistered(String guid, String title, String firstName, String lastName, String birthday, String gender) {
        this.guid = guid;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getGuid() {
        return guid;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }
}
