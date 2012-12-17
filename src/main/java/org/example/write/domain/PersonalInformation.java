package org.example.write.domain;

import static org.example.write.infrastructure.MatcherPreconditions.checkThatArgument;
import static org.example.write.infrastructure.StringMatchers.nullOrEmpty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

public class PersonalInformation {
    private final String title;
    private final String firstName;
    private final String lastName;
    private final Birthday birthday;
    private Gender gender;

    public PersonalInformation(String title, String firstName, String lastName, Birthday birthday, Gender gender) {
        this.title = checkThatArgument(title, not(nullOrEmpty()), "title");
        this.firstName = checkThatArgument(firstName, not(nullOrEmpty()), "firstName");
        this.lastName = checkThatArgument(lastName, not(nullOrEmpty()), "lastName");
        this.birthday = checkThatArgument(birthday, not(nullValue()), "birthday");
        this.gender = checkThatArgument(gender, not(nullValue()), "gender");
    }

    Gender getGender() {
        return gender;
    }

    void setGender(Gender gender) {
        this.gender = gender;
    }
}
