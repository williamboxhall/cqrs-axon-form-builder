package org.example.write.domain;

import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

public enum UnitOfMeasureImpl implements UnitOfMeasure {
    LENGTH_MILLIMETRE("length", "millimetre"),
    LENGTH_CENTIMETRE("length", "centimetre"),
    LENGTH_METRE("length", "metre"),
    LENGTH_KILOMETRE("length", "kilometre"),
    LENGTH_INCH("length", "inch"),
    LENGTH_FOOT("length", "foot"),
    TIME_YEAR("time", "year"),
    PERCENTAGE_PERCENT("percentage", "percent"),
    TEMPERATURE_CELSIUS("temperature", "celsius"),
    TEMPERATURE_FAHRENHEIT("temperature", "fahrenheit"),
    AREA_SQUARE_CENTIMETRE("area", "squarecentimetre");

    private final String quantity;
    private final String name;

    private UnitOfMeasureImpl(String quantity, String name) {
        this.quantity = quantity;
        this.name = name;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public static UnitOfMeasureImpl valueOfLowerHyphen(String name) {
        return UnitOfMeasureImpl.valueOf(LOWER_HYPHEN.to(UPPER_UNDERSCORE, name));
    }
}
