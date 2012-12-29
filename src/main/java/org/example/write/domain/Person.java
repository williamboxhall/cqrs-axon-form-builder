package org.example.write.domain;

import static java.lang.String.format;
import static org.example.write.infrastructure.MatcherPreconditions.checkThatArgument;
import static org.example.write.infrastructure.StringMatchers.nullOrEmpty;
import static org.hamcrest.Matchers.not;

import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.eventsourcing.domain.AggregateRoot;
import org.example.eventsourcing.domain.Guid;

public class Person extends AggregateRoot {
    private Gender gender;

    private void apply(PersonRegistered personRegistered) {
        this.gender = Gender.valueOfIgnoreCase(personRegistered.getGender());
    }

    private void apply(SexChanged sexChanged) {
        this.gender = Gender.valueOfIgnoreCase(sexChanged.getGender());
    }

    public static Person register(Guid guid, String title, String firstName, String lastName, String birthday, String gender) {
        Person person = new Person(guid);
        person.applyChange(new PersonRegistered(valid(title, "title"), valid(firstName, "firstName"),
                valid(lastName, "lastName"), validBirthday(birthday), validGender(gender)));
        return person;
    }

    private static String validGender(String gender) {
        Gender.valueOfIgnoreCase(gender);
        return gender;
    }

    private static String validBirthday(String birthday) {
        Birthday.valueOf(birthday);
        return birthday;
    }

    public void changeSex(String gender) {
        if (!this.gender.canChangeTo(Gender.valueOfIgnoreCase(gender))) {
            throw new IllegalArgumentException(format("Gender %s can not change to %s", this.gender, gender));
        }
        applyChange(new SexChanged(gender));
    }

    private static String valid(String value, String name) {
        return checkThatArgument(value, not(nullOrEmpty()), name);
    }

    private Person(Guid guid) {
        super(guid);
    }
}
