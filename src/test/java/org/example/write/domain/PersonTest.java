package org.example.write.domain;

import org.example.write.commands.RegisterPerson;
import org.junit.Test;

public class PersonTest {
    private static final String PERSON_ID = "123";
    private static final String BIRTHDAY = "2010-01-02";
    private static final String GENDER = "female";
    private static final String TITLE = "title";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullBirthday() {
        new Person(new RegisterPerson(PERSON_ID, TITLE, FIRST_NAME, LAST_NAME, null, GENDER));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidBirthday() {
        new Person(new RegisterPerson(PERSON_ID, TITLE, FIRST_NAME, LAST_NAME, "foo", GENDER));
    }

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullGender() {
        new Person(new RegisterPerson(PERSON_ID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, null));
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidGender() {
        new Person(new RegisterPerson(PERSON_ID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, "bar"));
    }
}
