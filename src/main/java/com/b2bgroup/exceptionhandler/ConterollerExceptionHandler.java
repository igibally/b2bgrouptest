package com.b2bgroup.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.b2bgroup.exception.ConstraintsViolationException;
import com.b2bgroup.exception.EntityNotFoundException;

@ControllerAdvice
public class ConterollerExceptionHandler
{
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handelEntityNotFoundException(EntityNotFoundException exp)
    {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exp.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);

    }
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exception(Exception exp)
    {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Invalid data !");
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
  
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handelConstraintsViolationException(ConstraintsViolationException exp)
    {
        ErrorResponse error = new ErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Some constraints are violated ...");
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }

}
