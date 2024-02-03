package com.crud.sunbase.exception;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String custUuid){
        super("Could not found the user with id "+custUuid);

    }

}