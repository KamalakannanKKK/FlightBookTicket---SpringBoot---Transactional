package com.SpringBoot.FlightBookTicket.Transactional.Annotation.Exception;
public class InsufficientAmountException extends RuntimeException {

    public InsufficientAmountException(String msg){
        super(msg);
    }
}
