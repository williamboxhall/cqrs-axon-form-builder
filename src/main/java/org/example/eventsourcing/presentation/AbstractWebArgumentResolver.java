package org.example.eventsourcing.presentation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

public abstract class AbstractWebArgumentResolver<T> implements WebArgumentResolver {
    private final Class<T> type;

    public AbstractWebArgumentResolver(Class<T> type) {
        this.type = type;
    }

    @Override
    public final Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) {
        return isResolvable(methodParameter) ? resolved(webRequest) : unresolved();
    }

    private boolean isResolvable(MethodParameter methodParameter) {
        return type.isAssignableFrom(methodParameter.getParameterType());
    }

    private T resolved(NativeWebRequest webRequest) {
        return resolveArgument(webRequest.getNativeRequest(HttpServletRequest.class));
    }

    private Object unresolved() {
        return WebArgumentResolver.UNRESOLVED;
    }

    protected abstract T resolveArgument(HttpServletRequest request);
}

