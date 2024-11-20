package ruandev.com.systemspringboot.exception;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails{
    private String fields;
    private String fieldsMessage;
}
