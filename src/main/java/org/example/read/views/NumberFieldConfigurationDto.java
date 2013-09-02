package org.example.read.views;

import javax.persistence.Entity;

@Entity
public class NumberFieldConfigurationDto extends FieldConfigurationDto {
    private String unitQuantity;
    private String unitName;
    private String unitSymbol;

    public NumberFieldConfigurationDto() {
    }

    public NumberFieldConfigurationDto(String name, String label, String hintText,
                                       String unitQuantity, String unitName, String unitSymbol) {
        super(name, label, hintText, "number");
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
