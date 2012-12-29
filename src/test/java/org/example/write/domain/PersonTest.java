package org.example.write.domain;

import org.example.eventsourcing.domain.Guid;
import org.junit.Test;

public class PersonTest {
    private static final Guid GUID = new Guid("123");
    private static final String BIRTHDAY = "2010-01-02";
    private static final String GENDER = "female";
    private static final String TITLE = "title";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test(expected = IllegalArgumentException.class)
    public void failsToRegisterWithNullTitle() {
        Person.register(GUID, null, FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankTitle() {
        Person.register(GUID, "", FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullFirstName() {
        Person.register(GUID, TITLE, null, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankFirstName() {
        Person.register(GUID, TITLE, "", LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullLastName() {
        Person.register(GUID, TITLE, FIRST_NAME, null, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankLastName() {
        Person.register(GUID, TITLE, FIRST_NAME, "", BIRTHDAY, GENDER);
    }

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullBirthday() {
        Person.register(GUID, TITLE, FIRST_NAME, LAST_NAME, null, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidBirthday() {
        Person.register(GUID, TITLE, FIRST_NAME, LAST_NAME, "foo", GENDER);
    }

    @Test(expected = NullPointerException.class)
    public void failsToCreateWithNullGender() {
        Person.register(GUID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithInvalidGender() {
        Person.register(GUID, TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, "bar");
    }
}
