package org.example.write.infrastructure;


import static com.google.common.base.Strings.isNullOrEmpty;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class StringMatchers {
    public static Matcher<String> nullOrEmpty() {
        return new TypeSafeMatcher<String>() {
            @Override
            protected boolean matchesSafely(String string) {
                return isNullOrEmpty(string);
            }

            @Override
            public void describeTo(Description description) {
                throw new RuntimeException("Test drive this class, it's been hacked together");
            }
        };
    }
}
