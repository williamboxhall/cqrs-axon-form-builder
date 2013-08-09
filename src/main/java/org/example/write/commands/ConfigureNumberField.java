package org.example.write.commands;

import javax.validation.constraints.NotNull;

import org.example.write.domain.UnitOfMeasure;

public class ConfigureNumberField extends ConfigureField {
    @NotNull
    private UnitOfMeasure unitOfMeasure;

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }
}
