package org.example.eventsourcing.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;

import org.example.eventsourcing.presentation.AbstractWebArgumentResolver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

@RunWith(MockitoJUnitRunner.class)
public class AbstractWebArgumentResolverTest {
    @Mock
    private MethodParameter methodParameter;
    @Mock
    private NativeWebRequest webRequest;
    @Mock
    private HttpServletRequest httpServletRequest;
    private StringArgumentResolver stringArgumentResolver;

    @Before
    public void setUp() {
        stringArgumentResolver = new StringArgumentResolver();
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldReturnUnresolvedWhenMethodParameterTypeDoesNotMatchTypePassedOnConstructor() {
        when(methodParameter.getParameterType()).thenReturn((Class) Integer.class);
        assertThat(stringArgumentResolver.resolveArgument(methodParameter, webRequest), is(WebArgumentResolver.UNRESOLVED));
    }

    @Test
    @SuppressWarnings("unchecked")
    public void shouldReturnResolvedArgumentFromChildWhenMethodParameterTypeMatchesTypePassedOnConstructor() {
        when(methodParameter.getParameterType()).thenReturn((Class) String.class);
        when(webRequest.getNativeRequest(HttpServletRequest.class)).thenReturn(httpServletRequest);
        assertThat(stringArgumentResolver.resolveArgument(methodParameter, webRequest), is((Object) "foo"));
    }

    private static final class StringArgumentResolver extends AbstractWebArgumentResolver<String> {
        private StringArgumentResolver() {
            super(String.class);
        }

        @Override
        protected String resolveArgument(HttpServletRequest request) {
            return "foo";
        }
    }
}