package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class BooleanFieldConfigurationDto extends FieldConfigurationDto {
    public BooleanFieldConfigurationDto() {
    }

    public BooleanFieldConfigurationDto(String name, String label, String hintText) {
        super(name, label, hintText, "checkbox");
    }
}
