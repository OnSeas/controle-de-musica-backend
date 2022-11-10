package com.ueg.controledemusica.exeptions.service;

public class ServiceException extends RuntimeException{
    public ServiceException (String message) {
        super(message);
    }
}
