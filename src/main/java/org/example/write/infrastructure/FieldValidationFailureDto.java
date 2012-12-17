package org.example.write.infrastructure;

public class FieldValidationFailureDto {
    private String entityName;
    private String fieldName;
    private Object value;
    private String message;

    public FieldValidationFailureDto(String entityName, String fieldName, Object value, String message) {
        this.entityName = entityName;
        this.fieldName = fieldName;
        this.value = value;
        this.message = message;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
