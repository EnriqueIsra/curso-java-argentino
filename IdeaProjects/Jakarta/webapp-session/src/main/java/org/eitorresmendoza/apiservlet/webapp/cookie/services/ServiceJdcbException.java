package org.eitorresmendoza.apiservlet.webapp.cookie.services;

public class ServiceJdcbException extends RuntimeException{
    public ServiceJdcbException(String message) {
        super(message);
    }

    public ServiceJdcbException(String message, Throwable cause) {
        super(message, cause);
    }
}
