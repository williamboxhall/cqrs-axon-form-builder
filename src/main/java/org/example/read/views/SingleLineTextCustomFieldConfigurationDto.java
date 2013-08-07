package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class SingleLineTextCustomFieldConfigurationDto extends CustomFieldConfigurationDto {
    private int minLength;
    private int maxLength;

    public SingleLineTextCustomFieldConfigurationDto() {
    }

    public SingleLineTextCustomFieldConfigurationDto(String guid, String context, String name, String locale,
                                                     String label, String hintText, int minLength, int maxLength) {
        super(guid, context, name, locale, label, hintText, "text");
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
