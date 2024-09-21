package ruandev.com.systemspringboot.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
@Data
@SuperBuilder
public class ExceptionDetails{
    protected String title;
    protected String developerMessage;
    protected String details;
    protected LocalDateTime timestamp;
    protected int status;
}
