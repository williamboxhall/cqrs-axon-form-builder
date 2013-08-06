package org.example.eventsourcing.presentation;

import static org.codehaus.jackson.Version.unknownVersion;

import java.util.Map;

import org.codehaus.jackson.map.JsonDeserializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.module.SimpleModule;

public class CustomObjectMapper extends ObjectMapper {
    @SuppressWarnings("unchecked")
    public CustomObjectMapper(Map<Class, JsonDeserializer> classToDeserializer) {
        SimpleModule module = new SimpleModule("JSONModule", unknownVersion());
        for (Map.Entry<Class, JsonDeserializer> entry : classToDeserializer.entrySet()) {
            module.addDeserializer(entry.getKey(), entry.getValue());
        }
        registerModule(module);
    }
}

