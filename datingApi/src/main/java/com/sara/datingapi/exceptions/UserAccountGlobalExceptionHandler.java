package com.sara.datingapi.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.NoSuchElementException;

@ControllerAdvice
public class UserAccountGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception exception,
                                                      WebRequest webRequest) {
        UserAccountExceptionResponse exceptionResponse = new UserAccountExceptionResponse(
                exception.getMessage(),
                webRequest.getDescription(false),
                new Date()
        );
        return new ResponseEntity<Object>(
                exceptionResponse,
                HttpStatus.BAD_REQUEST);
    }
}
