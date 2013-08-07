package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class NumberCustomFieldConfigurationDto extends CustomFieldConfigurationDto {
    private String unitQuantity;
    private String unitName;
    private String unitSymbol;

    public NumberCustomFieldConfigurationDto() {
    }

    public NumberCustomFieldConfigurationDto(String guid, String context, String name, String locale,
                                             String label, String hintText,
                                             String unitQuantity, String unitName, String unitSymbol) {
        super(guid, context, name, locale, label, hintText, "number");
        this.unitQuantity = unitQuantity;
        this.unitName = unitName;
        this.unitSymbol = unitSymbol;
    }

    public String getUnitQuantity() {
        return unitQuantity;
    }

    public String getUnitName() {
        return unitName;
    }

    public String getUnitSymbol() {
        return unitSymbol;
    }
}
