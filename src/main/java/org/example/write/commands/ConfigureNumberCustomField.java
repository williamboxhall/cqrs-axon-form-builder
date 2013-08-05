package org.example.write.commands;

import org.example.write.domain.UnitOfMeasure;

public class ConfigureNumberCustomField extends ConfigureCustomField {
    private UnitOfMeasure unitOfMeasure;

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
