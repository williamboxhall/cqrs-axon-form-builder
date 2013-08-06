package org.example.write.infrastructure;

import java.io.IOException;

import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;
import org.example.write.domain.UnitOfMeasure;
import org.example.write.domain.UnitOfMeasureImpl;

public class UnitOfMeasureSerializer extends FromStringDeserializer<UnitOfMeasure> {
    protected UnitOfMeasureSerializer() {
        super(UnitOfMeasure.class);
    }

    @Override
    protected UnitOfMeasure _deserialize(String value, DeserializationContext ctxt) throws IOException {
        return UnitOfMeasureImpl.valueOfLowerHyphen(value);
    }
}

