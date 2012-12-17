package org.example.write.infrastructure;

import static java.lang.String.format;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;

public final class MatcherPreconditions {
    private MatcherPreconditions() {
    }

    public static <T> T checkThatArgument(T object, Matcher<? super T> matcher) {
        if (!matcher.matches(object)) {
            Description description = new StringDescription();
            matcher.describeTo(description);
            throw new IllegalArgumentException(format("Argument [%s] does not match: %s", object, description));
        }
        return object;
    }

    public static <T> T checkThatArgument(T object, Matcher<? super T> matcher, Object errorMessage) {
        if (!matcher.matches(object)) {
            throw new IllegalArgumentException(String.valueOf(errorMessage));
        }
        return object;
    }

    public static <T> void checkThat(T object, Matcher<? super T> matcher) {
        if (!matcher.matches(object)) {
            Description description = new StringDescription();
            matcher.describeTo(description);
            throw new IllegalStateException(format("Object [%s] state does not match: %s", object, description));
        }
    }

    public static <T> void checkThat(T object, Matcher<? super T> matcher, Object errorMessage) {
        if (!matcher.matches(object)) {
            throw new IllegalStateException(String.valueOf(errorMessage));
        }
    }
}
