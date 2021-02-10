package com.michael.shorturl.exceptions;

public class InvalidURLException extends RuntimeException{
    public InvalidURLException(String url) {
        super("Not a valid URL :" + url);
    }
}
