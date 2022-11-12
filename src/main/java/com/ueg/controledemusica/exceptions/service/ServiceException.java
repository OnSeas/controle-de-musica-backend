package com.ueg.controledemusica.exceptions.service;

public class ServiceException extends RuntimeException{
    public ServiceException (String message) {
        super(message);
    }
}
