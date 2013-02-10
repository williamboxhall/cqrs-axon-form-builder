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
    private static final String ID = "foo";

    @Test
    public void sexChangesWhenDifferentToPrevious() {
        forA(Person.class)
                .registerInjectableResource(mock(PaymentService.class))
                .registerInjectableResource(mock(CatalogService.class))
                .given(new PersonRegistered(ID, null, null, null, null, "male"))
                .when(new ChangeSex(ID, "female"))
                .expectVoidReturnType()
                .expectEvents(new SexChanged("female"));
    }

    @Test
    public void failsToChangeSexWhenNotDifferentToPrevious() {
        forA(Person.class)
                .registerInjectableResource(mock(PaymentService.class))
                .registerInjectableResource(mock(CatalogService.class))
                .given(new PersonRegistered(ID, null, null, null, null, "male"))
                .when(new ChangeSex(ID, "male"))
                .expectException(withMessage("Gender MALE can not change to MALE", IllegalArgumentException.class));
    }
}
