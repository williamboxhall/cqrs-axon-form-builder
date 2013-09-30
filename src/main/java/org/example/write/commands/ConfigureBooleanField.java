package org.example.write.commands;

import org.hibernate.validator.constraints.NotBlank;

public class ConfigureBooleanField extends ConfigureField {
    public ConfigureBooleanField() {
    }

    public ConfigureBooleanField(String name, String label, String hintText) {
        super(name, label, hintText);
    }
}
