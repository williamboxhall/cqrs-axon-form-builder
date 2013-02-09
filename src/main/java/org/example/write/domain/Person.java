package org.example.write.domain;

import static java.lang.String.format;
import static org.example.write.infrastructure.MatcherPreconditions.checkThatArgument;
import static org.example.write.infrastructure.StringMatchers.nullOrEmpty;
import static org.hamcrest.Matchers.not;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.write.application.ChangeSex;
import org.example.write.application.RegisterPerson;

public class Person extends AbstractAnnotatedAggregateRoot<String> {
    @AggregateIdentifier
    private String guid;
    private Gender gender;

    private Person() {
    }

    @EventHandler
    private void on(PersonRegistered personRegistered) {
        this.guid = personRegistered.getGuid();
        this.gender = Gender.valueOfIgnoreCase(personRegistered.getGender());
    }

    @EventHandler
    private void on(SexChanged sexChanged) {
        this.gender = Gender.valueOfIgnoreCase(sexChanged.getGender());
    }

    @CommandHandler
    public Person(RegisterPerson registerPerson) {
        apply(new PersonRegistered(registerPerson.getGuid(), valid(registerPerson.getTitle(), "title"), valid(registerPerson.getFirstName(), "firstName"),
                valid(registerPerson.getLastName(), "lastName"), validBirthday(registerPerson.getBirthday()), validGender(registerPerson.getGender())));
    }

    @CommandHandler
    public void changeSex(ChangeSex changeSex) {
        if (!this.gender.canChangeTo(Gender.valueOfIgnoreCase(changeSex.getGender()))) {
            throw new IllegalArgumentException(format("Gender %s can not change to %s", this.gender, gender));
        }
        apply(new SexChanged(changeSex.getGender()));
    }

    private static String validGender(String gender) {
        Gender.valueOfIgnoreCase(gender);
        return gender;
    }

    private static String validBirthday(String birthday) {
        Birthday.valueOf(birthday);
        return birthday;
    }

    private static String valid(String value, String name) {
        return checkThatArgument(value, not(nullOrEmpty()), name);
    }
}
