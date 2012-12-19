package org.example.eventsourcing.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// TODO existing library for this?
public class Reflections {
    public static Class firstGenericTypeFrom(Class type) {
        Type genType = type.getGenericInterfaces()[0];
        if (genType instanceof ParameterizedType) {
            Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

            if ((params != null) && (params.length >= 1)) {
                return (Class) params[0];
            }
        }
        return null;
    }
}
