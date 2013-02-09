package org.example.write.application;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;
import org.example.eventsourcing.domain.Command;

public class RegisterPerson implements Command {
    @TargetAggregateIdentifier
    private String guid;
    private String title;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;

    public RegisterPerson() {
    }

    public RegisterPerson(String guid, String title, String firstName, String lastName, String birthday, String gender) {
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

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
