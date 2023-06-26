package com.digitalchief.controllers;

import com.digitalchief.exceptions.ExceptionResponse;
import com.digitalchief.exceptions.NonUniqueException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(NonUniqueException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchNonUniqueEmailException(NonUniqueException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }
}