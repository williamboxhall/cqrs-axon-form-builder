package org.example.write.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.example.write.commands.ConfigureTextField;
import org.junit.Before;
import org.junit.Test;

public class TextFieldTest {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 6;
    private TextField textField;

    @Before
    public void setUp() {
        textField = new TextField(new ConfigureTextField("name", "label", "hintText", MIN_LENGTH, MAX_LENGTH));
    }

    @Test
    public void validForRandomTextValue() {
        assertThat(textField.isValid("1a%ç "), is(true));
    }

    @Test
    public void invalidForTextValueShorterThanMinLength() {
        assertThat(textField.isValid("a"), is(false));
    }

    @Test
    public void invalidForTextValueLongerThanMaxLength() {
        assertThat(textField.isValid("1234567"), is(false));
    }

    @Test
    public void invalidForNullValue() {
        assertThat(textField.isValid(null), is(false));
    }

    @Test
    public void invalidForEmptyValue() {
        assertThat(textField.isValid(""), is(false));
    }

    @Test
    public void invalidForBlankValue() {
        assertThat(textField.isValid(" "), is(false));
    }
}
