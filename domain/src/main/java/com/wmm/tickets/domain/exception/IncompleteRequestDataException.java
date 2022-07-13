package com.wmm.tickets.domain.exception;

public class IncompleteRequestDataException extends RuntimeException{

    public IncompleteRequestDataException(String message){
        super(message);
    }
}
