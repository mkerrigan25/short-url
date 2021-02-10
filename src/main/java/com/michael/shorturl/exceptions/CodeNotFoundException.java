package com.michael.shorturl.exceptions;

public class CodeNotFoundException extends RuntimeException {
    public  CodeNotFoundException(String code){
        super("No link found for code: " + code);
    }

}
