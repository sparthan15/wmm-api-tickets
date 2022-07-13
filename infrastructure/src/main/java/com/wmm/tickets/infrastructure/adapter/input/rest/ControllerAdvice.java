package com.wmm.tickets.infrastructure.adapter.input.rest;

import com.wmm.tickets.domain.exception.IncompleteRequestDataException;
import com.wmm.tickets.infrastructure.adapter.config.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice()
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler( IncompleteRequestDataException.class)
    protected ResponseEntity<Object> incompleteRequestDataException(IncompleteRequestDataException ex,
                                                                                 WebRequest request) {
        return handleExceptionInternal(ex, new ErrorResponse(ex.getMessage()),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
