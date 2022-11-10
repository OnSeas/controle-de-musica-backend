package com.ueg.controledemusica.exeptions.advice;

import com.ueg.controledemusica.exeptions.service.ServiceErro;
import com.ueg.controledemusica.exeptions.service.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerAdviceApi {
    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<ServiceErro> resourceNotFound(ServiceException e, HttpServletRequest request) {
        String erro = "Recurso não encontrado";
        HttpStatus status = HttpStatus.NOT_FOUND;
        ServiceErro err = new ServiceErro(String.valueOf(status), e.getMessage());
        return ResponseEntity.status(status).body(err);
    }
}
