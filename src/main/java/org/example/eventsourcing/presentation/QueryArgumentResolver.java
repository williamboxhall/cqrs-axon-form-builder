package org.example.eventsourcing.presentation;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.PropertyUtils;
import org.example.eventsourcing.domain.Query;

public class QueryArgumentResolver extends AbstractWebArgumentResolver<Query> {
    public QueryArgumentResolver() {
        super(Query.class);
    }

    @Override
    protected Query resolveArgument(HttpServletRequest request) {
        return populateFromRequest(create(typeFrom(request)), request);
    }

    private Query create(Class<Query> type) {
        try {
            return type.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Query populateFromRequest(Query query, HttpServletRequest request) {
        Map<String, String> queryParameters = request.getParameterMap();
        try {
            for (String key : queryParameters.keySet()) {
                PropertyUtils.setProperty(query, key, request.getParameter(key));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return query;
    }

    public static Class<Query> typeFrom(HttpServletRequest request) {
        return typeFor(nameFrom(request));
    }

    private static String nameFrom(HttpServletRequest request) {
        return request.getRequestURI().split("/read/")[1];
    }

    private static Class<Query> typeFor(String name) {
        try {
            return (Class<Query>) Class.forName("org.example.read.queries." + name);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
