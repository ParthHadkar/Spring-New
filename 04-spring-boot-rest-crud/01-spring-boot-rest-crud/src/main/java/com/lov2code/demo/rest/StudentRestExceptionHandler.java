package com.lov2code.demo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    // Add a exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException studentNotFoundException){
        // create a student error response object
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentNotFoundException.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }

    // Add another exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception){
        // create a student error response object
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();
        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exception.getMessage());
        studentErrorResponse.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }

}
