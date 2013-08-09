package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class TextFieldConfigurationDto extends FieldConfigurationDto {
    private int minLength;
    private int maxLength;

    public TextFieldConfigurationDto() {
    }

    public TextFieldConfigurationDto(String guid, String name, String label, String hintText,
                                     int minLength, int maxLength) {
        super(guid, name, label, hintText, "text");
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
}
