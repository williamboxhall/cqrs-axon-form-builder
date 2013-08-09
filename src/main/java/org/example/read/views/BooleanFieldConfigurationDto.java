package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class BooleanFieldConfigurationDto extends FieldConfigurationDto {
    public BooleanFieldConfigurationDto() {
    }

    public BooleanFieldConfigurationDto(String guid, String name, String label, String hintText) {
        super(guid, name, label, hintText, "checkbox");
    }
}
