package org.example.eventsourcing.presentation;

import static java.lang.Class.forName;

import java.util.Map;

import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

public class CustomObjectMapper extends ObjectMapper {
    public CustomObjectMapper(Map<String, JsonSerializer> classToSerializer) {
        CustomSerializerFactory customSerializerFactory = new CustomSerializerFactory();
        for (Map.Entry<String, JsonSerializer> entry : classToSerializer.entrySet()) {
            registerWith(entry, customSerializerFactory);
        }
        this.setSerializerFactory(customSerializerFactory);
    }

    @SuppressWarnings("unchecked")
    private void registerWith(Map.Entry<String, JsonSerializer> entry, final CustomSerializerFactory customSerializerFactory) {
        try {
            customSerializerFactory.addGenericMapping(forName(entry.getKey()), entry.getValue());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

