package org.example.events;

import org.example.eventsourcing.domain.Event;

public class PersonRegistered extends Event {
    private final String personId;
    private final String title;
    private final String firstName;
    private final String lastName;
    private final String birthday;
    private final String gender;

    public PersonRegistered(String personId, String title, String firstName, String lastName, String birthday, String gender) {
        this.personId = personId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getPersonId() {
        return personId;
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
