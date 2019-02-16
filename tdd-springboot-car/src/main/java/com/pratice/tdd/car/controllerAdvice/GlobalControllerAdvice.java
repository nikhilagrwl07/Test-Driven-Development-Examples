package com.pratice.tdd.car.controllerAdvice;

import com.pratice.tdd.car.exception.CarNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler({CarNotFoundException.class})
    public ResponseEntity<ErrorResponse> invalidGoalExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setMessage(ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
