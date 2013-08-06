package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class NumberCustomFieldConfigurationDto extends CustomFieldConfigurationDto {
    private String unitQuantity;
    private String unitName;

    public NumberCustomFieldConfigurationDto() {
    }

    public NumberCustomFieldConfigurationDto(String guid, String context, String name, String locale,
                                             String label, String hintText, String unitQuantity, String unitName) {
        super(guid, context, name, locale, label, hintText);
        this.unitQuantity = unitQuantity;
        this.unitName = unitName;
    }

    public String getUnitQuantity() {
        return unitQuantity;
    }

    public String getUnitName() {
        return unitName;
    }
}
