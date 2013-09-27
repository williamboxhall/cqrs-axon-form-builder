package org.example.eventsourcing.infrastructure;

import static org.axonframework.common.ReflectionUtils.ensureAccessible;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.example.write.domain.Field;

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

    public static Field newInstanceOf(Class<? extends Field> type) {
        try {
            return ensureAccessible(type.getDeclaredConstructor()).newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
