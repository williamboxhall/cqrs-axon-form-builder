package org.example.write.commands;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(lang = "javascript", script = "_this.minLength <= _this.maxLength",
        message = "Maximum length of SingleLineText must not be less than the minimum length")
public class ConfigureTextField extends ConfigureField {
    @Min(0)
    private int minLength;
    private int maxLength;

    public int getMinLength() {
        return minLength;
    }

    public void setMinLength(int minLength) {
        this.minLength = minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }
}
