package com.wmm.tickets.domain.exception;

public class IncompleteResponseDataException extends RuntimeException{

    public IncompleteResponseDataException(String message){
        super(message);
    }
}
