package org.example.write.infrastructure;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Lists.transform;

import java.lang.reflect.Field;
import java.util.List;

import com.google.common.base.Function;
import net.sf.oval.ConstraintViolation;
import net.sf.oval.context.FieldContext;
import net.sf.oval.exception.ConstraintsViolatedException;
import org.springframework.stereotype.Component;

@Component
public class ValidationExceptionConverter {
    public EntityValidationFailureDto convert(ConstraintsViolatedException ex) {
        List<FieldValidationFailureDto> fields = transform(newArrayList(ex.getConstraintViolations()), toFields());
        return new EntityValidationFailureDto(fields);
    }

    private Function<ConstraintViolation, FieldValidationFailureDto> toFields() {
        return new Function<ConstraintViolation, FieldValidationFailureDto>() {
            public FieldValidationFailureDto apply(ConstraintViolation constraintViolation) {
                Field field = ((FieldContext) constraintViolation.getContext()).getField();
                String entityName = field.getDeclaringClass().getSimpleName();
                String fieldName = field.getName();
                Object value = constraintViolation.getInvalidValue();
                String message = constraintViolation.getMessage();
                return new FieldValidationFailureDto(entityName, fieldName, value, message);
            }
        };
    }
}
