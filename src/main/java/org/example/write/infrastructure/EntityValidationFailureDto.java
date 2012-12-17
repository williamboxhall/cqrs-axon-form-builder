package org.example.write.infrastructure;

import java.util.List;

public class EntityValidationFailureDto {
    private List<FieldValidationFailureDto> failures;

    public EntityValidationFailureDto(List<FieldValidationFailureDto> failures) {
        this.failures = failures;
    }

    public List<FieldValidationFailureDto> getFailures() {
        return failures;
    }

    public void setFailures(List<FieldValidationFailureDto> failures) {
        this.failures = failures;
    }
}
