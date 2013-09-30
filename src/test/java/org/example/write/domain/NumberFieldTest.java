package org.example.write.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

import org.example.write.commands.ConfigureNumberField;
import org.junit.Before;
import org.junit.Test;

public class NumberFieldTest {
    private NumberField numberField;

    @Before
    public void setUp() {
        numberField = new NumberField(new ConfigureNumberField("name", "label", "hintText", mock(UnitOfMeasure.class)));
    }

    @Test
    public void validForIntegerValue() {
        assertThat(numberField.isValid("123"), is(true));
    }

    @Test
    public void invalidForFractionalNumberValue() {
        assertThat(numberField.isValid("12.3"), is(false));
    }

    @Test
    public void invalidForNullValue() {
        assertThat(numberField.isValid(null), is(false));
    }

    @Test
    public void invalidForEmptyValue() {
        assertThat(numberField.isValid(""), is(false));
    }

    @Test
    public void invalidForBlankValue() {
        assertThat(numberField.isValid(" "), is(false));
    }

    @Test
    public void invalidForStringValue() {
        assertThat(numberField.isValid("foo"), is(false));
    }

}
