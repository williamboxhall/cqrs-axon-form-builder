package org.example.events;

import org.example.eventsourcing.domain.Event;

public class PersonRegistered extends Event {
    private final String title;
    private final String firstName;
    private final String lastName;
    private final String birthday;
    private final String gender;

    public PersonRegistered(String title, String firstName, String lastName, String birthday, String gender) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.gender = gender;
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
