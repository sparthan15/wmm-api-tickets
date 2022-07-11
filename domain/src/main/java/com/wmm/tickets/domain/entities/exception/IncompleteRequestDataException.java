package com.wmm.tickets.domain.entities.exception;

public class IncompleteRequestDataException extends RuntimeException{

    public IncompleteRequestDataException(String message){
        super(message);
    }
}
