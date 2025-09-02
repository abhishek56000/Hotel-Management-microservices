package com.abhi.user.service.UserService.exceptions;

import com.abhi.user.service.UserService.payload.ApiRespnse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiRespnse> handleResourceNotFoundException(ResourceNotFoundException e){

        String message = e.getMessage();
       ApiRespnse respnse =  ApiRespnse.builder().message(message).success(true).status(HttpStatus.NOT_FOUND).build();
       return new ResponseEntity<>(respnse,HttpStatus.NOT_FOUND);
    }

}
