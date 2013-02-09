package org.example.write.application;

import static org.example.write.infrastructure.Fixtures.forA;
import static org.example.write.infrastructure.Fixtures.withMessage;

import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.write.domain.Person;
import org.junit.Test;

public class ChangeSexTest {
    private static final String ID = "foo";

    @Test
    public void sexChangesWhenDifferentToPrevious() {
        forA(Person.class)
                .given(new PersonRegistered(ID, null, null, null, null, "male"))
                .when(new ChangeSex(ID, "female"))
                .expectVoidReturnType()
                .expectEvents(new SexChanged("female"));
    }

    @Test
    public void failsToChangeSexWhenNotDifferentToPrevious() {
        forA(Person.class)
                .given(new PersonRegistered(ID, null, null, null, null, "male"))
                .when(new ChangeSex(ID, "male"))
                .expectException(withMessage("Gender MALE can not change to MALE", IllegalArgumentException.class));
    }
}
