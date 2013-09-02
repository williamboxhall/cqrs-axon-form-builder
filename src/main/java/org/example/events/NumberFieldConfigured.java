package org.example.events;

public class NumberFieldConfigured extends FieldConfigured {
    private final String unitQuantity;
    private final String unitName;
    private final String unitSymbol;

    public NumberFieldConfigured(String name, String label,
                                 String hintText, String unitQuantity, String unitName, String unitSymbol) {
        super(name, label, hintText);
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
