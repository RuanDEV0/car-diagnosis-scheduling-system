package ruandev.com.systemspringboot.handler;

import io.micrometer.common.lang.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ruandev.com.systemspringboot.exception.BadRequestException;
import ruandev.com.systemspringboot.exception.BadRequestExceptionDetails;
import ruandev.com.systemspringboot.exception.ExceptionDetails;

import java.time.LocalDateTime;

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
}
