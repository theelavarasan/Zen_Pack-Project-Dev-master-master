package com.ZenPack.exception;

public class AccessDeniedException extends RuntimeException{
    AccessDeniedException(String message){
        super(message);
    }
}
