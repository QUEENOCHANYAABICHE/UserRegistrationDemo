package com.example.userregesterationdemo.Exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String message){
       super(message);
    }
}
