package org.example.write.infrastructure;

import org.axonframework.domain.AbstractAggregateRoot;
import org.axonframework.eventsourcing.EventSourcedAggregateRoot;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.GivenWhenThenTestFixture;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Fixtures {
    private Fixtures() {
    }

    public static <T extends EventSourcedAggregateRoot> FixtureConfiguration<T> forA(
            Class<T> aggregateType) {
        return org.axonframework.test.Fixtures.newGivenWhenThenFixture(aggregateType);
    }


    public static Matcher<Throwable> withMessage(final String message, final Class<? extends Throwable> type) {
        return new TypeSafeMatcher<Throwable>() {
            @Override
            protected boolean matchesSafely(Throwable throwable) {
                return throwable.getClass().isAssignableFrom(type) && message.equals(throwable.getMessage());
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("%s with message '%s'", type.getSimpleName(), message));
            }
        };
    }
}
