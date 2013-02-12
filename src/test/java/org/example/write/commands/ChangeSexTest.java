package org.example.write.commands;

import static org.example.write.infrastructure.Fixtures.forA;
import static org.example.write.infrastructure.Fixtures.withMessage;
import static org.mockito.Mockito.mock;

import org.example.events.PersonRegistered;
import org.example.events.SexChanged;
import org.example.write.domain.Person;
import org.example.write.services.CatalogService;
import org.example.write.services.PaymentService;
import org.junit.Test;

public class ChangeSexTest {
    private static final String PERSON_ID = "foo";

    @Test
    public void sexChangesWhenDifferentToPrevious() {
        forA(Person.class)
                .registerInjectableResource(mock(PaymentService.class))
                .registerInjectableResource(mock(CatalogService.class))
                .given(new PersonRegistered(PERSON_ID, null, null, null, null, "male"))
                .when(new ChangeSex(PERSON_ID, "female"))
                .expectVoidReturnType()
                .expectEvents(new SexChanged(PERSON_ID, "female"));
    }

    @Test
    public void failsToChangeSexWhenNotDifferentToPrevious() {
        forA(Person.class)
                .registerInjectableResource(mock(PaymentService.class))
                .registerInjectableResource(mock(CatalogService.class))
                .given(new PersonRegistered(PERSON_ID, null, null, null, null, "male"))
                .when(new ChangeSex(PERSON_ID, "male"))
                .expectException(withMessage("Gender MALE can not change to MALE", IllegalArgumentException.class));
    }
}
