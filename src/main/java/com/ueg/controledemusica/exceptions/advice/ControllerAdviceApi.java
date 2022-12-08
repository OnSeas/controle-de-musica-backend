package com.ueg.controledemusica.exceptions.advice;

import com.ueg.controledemusica.exceptions.service.ServiceErro;
import com.ueg.controledemusica.exceptions.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceApi {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceErro> resourceNotFound(ServiceException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ServiceErro err = new ServiceErro(String.valueOf(status), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
