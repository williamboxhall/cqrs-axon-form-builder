package org.example.read.views;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.annotations.AccessType;

@Entity
@AccessType("field")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CustomFieldConfigurationDto {
    @Id
    private String customFieldGuid;
    private String context;
    private String name;
    private String locale;
    private String label;
    private String tooltip;

    public CustomFieldConfigurationDto() {
    }

    public CustomFieldConfigurationDto(String customFieldGuid, String context, String name, String locale, String label, String tooltip) {
        this.customFieldGuid = customFieldGuid;
        this.context = context;
        this.name = name;
        this.locale = locale;
        this.label = label;
        this.tooltip = tooltip;
    }

    public String getCustomFieldGuid() {
        return customFieldGuid;
    }

    public String getContext() {
        return context;
    }

    public String getName() {
        return name;
    }

    public String getLocale() {
        return locale;
    }

    public String getLabel() {
        return label;
    }

    public String getTooltip() {
        return tooltip;
    }
}
