package com.commerce.commerce.Controllers;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.commerce.commerce.Exceptions.ExceptionObject;
import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Exceptions.NotFoundException;

@ControllerAdvice
public class Advice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionObject>invalidInputs(MethodArgumentNotValidException exception){
      ExceptionObject exceptionObject=new ExceptionObject();
     List<ObjectError> errors=exception.getAllErrors();
     for (ObjectError objectError : errors) {
        exceptionObject.setMessage(objectError.getDefaultMessage());
     }
        return new ResponseEntity<ExceptionObject>(exceptionObject,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(FoundException.class)
    public ResponseEntity<ExceptionObject>foundException(FoundException exception){
      ExceptionObject exceptionObject=new ExceptionObject();

        exceptionObject.setMessage(exception.getMessage());

        return new ResponseEntity<ExceptionObject>(exceptionObject,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionObject>notFoundException(NotFoundException exception){
      ExceptionObject exceptionObject=new ExceptionObject();

        exceptionObject.setMessage(exception.getMessage());

        return new ResponseEntity<ExceptionObject>(exceptionObject,HttpStatus.NOT_FOUND);
    }
    
}
