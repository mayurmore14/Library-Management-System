package com.infogalaxy.librarymanagementsystem.exceptions;

import com.infogalaxy.librarymanagementsystem.responses.Responses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> memberNotFoundEx( MemberNotFoundException ex) {
        return new ResponseEntity<>("Data Not found With Given ID , Please Enter Valid Input Data", HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String ,String> errormap = new HashMap<>();
        for (FieldError field : ex.getFieldErrors()){
            errormap.put(field.getField(), field.getDefaultMessage());

        }
        return new ResponseEntity<>(new Responses("Please Check Input Data...",HttpStatus.BAD_REQUEST,errormap),HttpStatus.BAD_REQUEST);
    }
}
