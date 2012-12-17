package org.example.write.infrastructure;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.oval.exception.ConstraintsViolatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component
public class ValidationHandlerExceptionResolver implements HandlerExceptionResolver {
    @Autowired
    private ValidationExceptionConverter validationExceptionConverter;

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (ex instanceof ConstraintsViolatedException) {
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return new ModelAndView().addObject("validationResult", validationExceptionConverter.convert((ConstraintsViolatedException) ex));
        }
        return null;
    }
}
