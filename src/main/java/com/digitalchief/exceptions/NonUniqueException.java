package com.digitalchief.exceptions;

public class NonUniqueException extends RuntimeException{
    public NonUniqueException(String message) {
        super(message);
    }
}
