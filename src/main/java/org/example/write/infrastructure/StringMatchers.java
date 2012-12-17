package org.example.write.infrastructure;


import static com.google.common.base.Strings.isNullOrEmpty;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class StringMatchers {
    public static Matcher<String> nullOrEmpty() {
        return new BaseMatcher<String>() {
            @Override
            public boolean matches(Object string) {
                return isNullOrEmpty((String) string);
            }

            @Override
            public void describeTo(Description description) {
                throw new RuntimeException("Test drive this class, it's been hacked together");
            }
        };
    }
}
