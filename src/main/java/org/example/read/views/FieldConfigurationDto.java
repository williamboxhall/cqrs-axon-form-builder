package org.example.read.views;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.AccessType;

@Entity
@AccessType("field")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class FieldConfigurationDto {
    @Id
    private String name;
    private String label;
    private String hintText;
    private String type;

    public FieldConfigurationDto() {
    }

    public FieldConfigurationDto(String name, String label, String hintText, String type) {
        this.name = name;
        this.label = label;
        this.hintText = hintText;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getHintText() {
        return hintText;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
