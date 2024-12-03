package ruandev.com.systemspringboot.handler;

import io.micrometer.common.lang.Nullable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.exception.BadRequestExceptionDetails;
import ruandev.com.systemspringboot.exception.ExceptionDetails;
import ruandev.com.systemspringboot.exception.ValidationExceptionDetails;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException badRequestException){
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .details(badRequestException.getMessage())
                .title("Bad Request exception, check documentation")
                .developerMessage(badRequestException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .build(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ValidationExceptionDetails> handlerConstraintViolationException(ConstraintViolationException constraintViolationException){
        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .details(constraintViolationException.getMessage())
                .fields(constraintViolationException.getConstraintViolations().stream().toList().toString())
                .timestamp(LocalDateTime.now())
                .developerMessage(constraintViolationException.getClass().getName())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("ValidatinExceptionDetails, check the documentation!")
                .fieldsMessage(constraintViolationException.getLocalizedMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body
            , HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .status(statusCode.value())
                .title(ex.getCause().getMessage())
                .details(ex.getMessage())
                .developerMessage(ex.getClass().getName())
                .build();
        return this.createResponseEntity(exceptionDetails, headers, statusCode, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .timestamp(LocalDateTime.now())
                .fields(fields)
                .fieldsMessage(fieldsMessage)
                .developerMessage(ex.getClass().getName())
                .title("Validation Exception, Invalid fields")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
