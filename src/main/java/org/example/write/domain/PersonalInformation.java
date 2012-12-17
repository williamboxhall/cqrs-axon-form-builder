package org.example.write.domain;

import static com.google.common.base.Preconditions.checkNotNull;
import static org.example.write.infrastructure.MatcherPreconditions.checkThatArgument;
import static org.example.write.infrastructure.StringMatchers.nullOrEmpty;
import static org.hamcrest.Matchers.not;

public class PersonalInformation {
    private final String title;
    private final String firstName;
    private final String lastName;
    private final Birthday dateOfBirth;
    private final Gender gender;

    public PersonalInformation(String title, String firstName, String lastName, Birthday dateOfBirth, Gender gender) {
        this.title = checkThatArgument(title, not(nullOrEmpty()));
        this.firstName = checkThatArgument(firstName, not(nullOrEmpty()));
        this.lastName = checkThatArgument(lastName, not(nullOrEmpty()));
        this.dateOfBirth = checkNotNull(dateOfBirth);
        this.gender = checkNotNull(gender);
    }
}
