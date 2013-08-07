package org.example.write.domain;

import static com.google.common.base.CaseFormat.LOWER_HYPHEN;
import static com.google.common.base.CaseFormat.UPPER_UNDERSCORE;

public enum UnitOfMeasureImpl implements UnitOfMeasure {
    LENGTH_MILLIMETRE("length", "millimetre", "mm"),
    LENGTH_CENTIMETRE("length", "centimetre", "cm"),
    LENGTH_METRE("length", "metre", "m"),
    LENGTH_KILOMETRE("length", "kilometre", "km"),
    LENGTH_INCH("length", "inch", "in"),
    LENGTH_FOOT("length", "foot", "ft"),
    TIME_YEAR("time", "year", "yrs"),
    PERCENTAGE_PERCENT("percentage", "percent", "%"),
    TEMPERATURE_CELSIUS("temperature", "celsius", "°C"),
    TEMPERATURE_FAHRENHEIT("temperature", "fahrenheit", "°F"),
    AREA_SQUARE_CENTIMETRE("area", "squarecentimetre", "cm");

    private final String quantity;
    private final String name;
    private final String symbol;

    private UnitOfMeasureImpl(String quantity, String name, String symbol) {
        this.quantity = quantity;
        this.name = name;
        this.symbol = symbol;
    }

    public static UnitOfMeasureImpl valueOfLowerHyphen(String name) {
        return UnitOfMeasureImpl.valueOf(LOWER_HYPHEN.to(UPPER_UNDERSCORE, name));
    }

    public String getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
}
