package com.example.Expense.Management.System.com.expenseManagement.system.advice;

import com.example.Expense.Management.System.com.expenseManagement.system.customException.EmptyInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException){
        return new ResponseEntity<>("Input Field is empty , please have a look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArg(IllegalArgumentException illegalArgumentException){
        return new ResponseEntity<>("Input Field is null , please have a look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElemenmt(NoSuchElementException noSuchElementException){
        return new ResponseEntity<>("Input Field does not exist in the database , please have a look into it", HttpStatus.BAD_REQUEST);
    }


}
