package org.example.read.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonProfile {
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

    public PersonProfile personId(String guid) {
        this.personId = guid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PersonProfile title(String title) {
        this.title = title;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public PersonProfile firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public PersonProfile lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBirthday() {
        return birthday;
    }

    public PersonProfile birthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public PersonProfile gender(String gender) {
        this.gender = gender;
        return this;
    }

    public PersonProfile spent(double cost) {
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
