package de.neuefische.springexceptionhandlingtask.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleIllegalArgumentException(IllegalArgumentException e) {
        return new ErrorMessage(e.getMessage(), HttpStatus.FORBIDDEN.value(), LocalDateTime.now());
    }
}
