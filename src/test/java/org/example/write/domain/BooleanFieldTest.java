package org.example.write.domain;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.example.write.commands.ConfigureBooleanField;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BooleanFieldTest {
    private BooleanField booleanField;

    @Before
    public void setUp() {
        booleanField = new BooleanField(new ConfigureBooleanField("name", "label", "hintText"));
    }

    @Test
    public void validForTrueValue() {
        assertThat(booleanField.isValid("true"), is(true));
    }

    @Test
    public void validForFalseValue() {
        assertThat(booleanField.isValid("false"), is(true));
    }

    @Test
    public void invalidForNullValue() {
        assertThat(booleanField.isValid(null), is(false));
    }

    @Test
    public void invalidForEmptyValue() {
        assertThat(booleanField.isValid(""), is(false));
    }

    @Test
    public void invalidForBlankValue() {
        assertThat(booleanField.isValid(" "), is(false));
    }

    @Test
    public void invalidForStringValue() {
        assertThat(booleanField.isValid("foo"), is(false));
    }
}
