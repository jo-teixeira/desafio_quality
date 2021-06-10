package com.mercadolivre.DesafioQuality.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
                                                    HttpServletRequest httpServletRequest) {
        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
                "Validation error", System.currentTimeMillis(), httpServletRequest.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<StandardError> validation(DistrictNotFoundException e,
                                                    HttpServletRequest httpServletRequest) {
        ValidationError err = new ValidationError(HttpStatus.NOT_FOUND.value(),
                e.getMessage(), System.currentTimeMillis(), httpServletRequest.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
