package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class BooleanCustomFieldConfigurationDto extends CustomFieldConfigurationDto {
    public BooleanCustomFieldConfigurationDto() {
    }

    public BooleanCustomFieldConfigurationDto(String guid, String context, String name, String locale, String label, String tooltip) {
        super(guid, context, name, locale, label, tooltip);
    }
}
