package com.sara.datingapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class InterestController {

    @ExceptionHandler(Exception.class)
    public void handleException() {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
    }
}
