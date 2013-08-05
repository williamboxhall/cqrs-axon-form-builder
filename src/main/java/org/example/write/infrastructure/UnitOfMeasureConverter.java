package org.example.write.infrastructure;

import org.example.write.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;

public class UnitOfMeasureConverter implements Converter<String, UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(String name) {
        return UnitOfMeasure.valueOfLowerHyphen(name);
    }
}
