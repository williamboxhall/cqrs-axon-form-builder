package org.example.write.infrastructure;

import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MatcherPreconditionsTest {
    private static final String ERROR_MESSAGE = "tick tick tick tick boom!";

    @Test
    public void checkThatArgumentShouldReturnArgumentWhenMatched() {
        Object foo = new Object();
        assertThat(MatcherPreconditions.checkThatArgument(foo, anything()), sameInstance(foo));
    }

    @Test
    public void checkThatArgumentShouldThrowIllegalArgumentExceptionWithMatcherDescriptionWhenNotMatched() {
        try {
            MatcherPreconditions.checkThatArgument("foo", not(anything()));
            fail("expected exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is("Argument [foo] does not match: not ANYTHING"));
        }
    }

    @Test
    public void checkThatArgumentWithMessageShouldReturnArgumentWhenMatched() {
        Object foo = new Object();
        assertThat(MatcherPreconditions.checkThatArgument(foo, anything(), ERROR_MESSAGE), sameInstance(foo));
    }

    @Test
    public void checkThatArgumentWithMessageShouldThrowExceptionWithAppropriateMessage() {
        try {
            MatcherPreconditions.checkThatArgument(new Object(), not(anything()), ERROR_MESSAGE);
            fail("expected exception");
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage(), is(ERROR_MESSAGE));
        }
    }

    @Test
    public void checkThatShouldThrowIllegalStateExceptionWithMatcherDescriptionWhenNotMatched() {
        try {
            MatcherPreconditions.checkThat("bar", not(anything()));
            fail("expected exception");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), is("Object [bar] state does not match: not ANYTHING"));
        }
    }

    @Test
    public void checkThatWithMessageShouldThrowExceptionWithAppropriateMessage() {
        try {
            MatcherPreconditions.checkThat(new Object(), not(anything()), ERROR_MESSAGE);
            fail("expected exception");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage(), is(ERROR_MESSAGE));
        }
    }
}
