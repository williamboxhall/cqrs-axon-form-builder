package org.example.write.domain;

import org.junit.Test;

public class PersonalInformationTest {
    private static final Birthday BIRTHDAY = Birthday.valueOf("2010-01-02");
    private static final Gender GENDER = Gender.FEMALE;
    private static final String TITLE = "title";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullTitle() {
        new PersonalInformation(null, FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankTitle() {
        new PersonalInformation("", FIRST_NAME, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullFirstName() {
        new PersonalInformation(TITLE, null, LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankFirstName() {
        new PersonalInformation(TITLE, "", LAST_NAME, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullLastName() {
        new PersonalInformation(TITLE, FIRST_NAME, null, BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithBlankLastName() {
        new PersonalInformation(TITLE, FIRST_NAME, "", BIRTHDAY, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullBirthday() {
        new PersonalInformation(TITLE, FIRST_NAME, LAST_NAME, null, GENDER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void failsToCreateWithNullGender() {
        new PersonalInformation(TITLE, FIRST_NAME, LAST_NAME, BIRTHDAY, null);
    }
}
