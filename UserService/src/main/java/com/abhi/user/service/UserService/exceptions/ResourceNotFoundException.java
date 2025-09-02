package com.abhi.user.service.UserService.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource not found by given id");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
