package com.digitalchief.controllers.handlers;

import com.digitalchief.exceptions.ConstraintException;
import com.digitalchief.exceptions.ExceptionResponse;
import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
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
    public ExceptionResponse catchNonUniqueException(NonUniqueException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ExceptionResponse catchNotFoundException(NotFoundException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(ConstraintException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchConstraintException(ConstraintException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }
}