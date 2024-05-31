package com.example.dd.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundByUserNameException extends RuntimeException{
    public NotFoundByUserNameException(String message) {
        super(message);
    }
}
