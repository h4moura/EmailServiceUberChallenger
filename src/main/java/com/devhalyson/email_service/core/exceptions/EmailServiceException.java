package com.devhalyson.email_service.core.exceptions;

public class EmailServiceException extends RuntimeException {
    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceExecption(String message, Throwable cause){
        super(message, cause);
    }
}
