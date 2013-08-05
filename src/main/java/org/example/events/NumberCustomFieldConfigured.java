package org.example.events;

public class NumberCustomFieldConfigured extends CustomFieldConfigured {
    private final String unitQuantity;
    private final String unitName;

    public NumberCustomFieldConfigured(String guid, String context, String name, String locale, String label, String hintText, String unitQuantity, String unitName) {
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
