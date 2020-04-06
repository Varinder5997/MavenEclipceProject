package com.mindtree.buspassenger.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.buspassenger.dto.ErrorResponse;
import com.mindtree.buspassenger.exception.ApplicationException;
import com.mindtree.buspassenger.exception.service.AlreadyBookBus;
import com.mindtree.buspassenger.exception.service.NoSeatAvailable;
import com.mindtree.buspassenger.exception.service.ServiceException;
import com.mindtree.buspassenger.exception.service.TicketNotBook;

import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class RestExceptionHandler {

    
    @ExceptionHandler(value = { NoSeatAvailable.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse noSeatAvailabe(ApplicationException e)
    {
        return new ErrorResponse(404, e.getMessage());
    }
    
    @ExceptionHandler(value = {TicketNotBook.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse noTicketBook(ApplicationException e) {
    	return new ErrorResponse(406,e.getMessage());
    }
    
    @ExceptionHandler(value = {AlreadyBookBus.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public ErrorResponse alreadyBookedAbus(ApplicationException e) {
    	return new ErrorResponse(406,e.getMessage());
    }
}