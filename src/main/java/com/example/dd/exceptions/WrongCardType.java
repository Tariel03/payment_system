package com.example.dd.exceptions;

public class WrongCardType extends RuntimeException{
    public WrongCardType(String message) {
        super(message);
    }
}

