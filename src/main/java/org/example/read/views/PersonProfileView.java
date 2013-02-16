package org.example.read.views;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonProfileView {
    @Id
    private String personId;
    private String title;
    private String firstName;
    private String lastName;
    private String birthday;
    private String gender;
    private int numberOfThingsBought;
    private double spent;

    public String getPersonId() {
        return personId;
    }

    public PersonProfileView personId(String guid) {
        this.personId = guid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PersonProfileView title(String title) {
        this.title = title;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonProfileView firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonProfileView lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public PersonProfileView birthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PersonProfileView gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonProfileView spent(double cost) {
        this.numberOfThingsBought++;
        this.spent += cost;
        return this;
    }

    public int getNumberOfThingsBought() {
        return numberOfThingsBought;
    }

    public String getSpent() {
        return "$" + spent;
    }
}
