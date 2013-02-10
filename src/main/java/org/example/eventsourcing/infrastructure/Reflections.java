package org.example.eventsourcing.infrastructure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

// TODO existing library for this?
public class Reflections {
    public static Class secondGenericTypeFromInterfaceOnClass(Class interfaceType, Class classType) {
        for (Type genType : classType.getGenericInterfaces()) {
            if (genType instanceof ParameterizedType && ((ParameterizedType) genType).getRawType() == interfaceType) {
                Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

                if ((params != null) && (params.length >= 2)) {
                    return (Class) params[1];
                }
            }
        }

        return null;
    }
}
