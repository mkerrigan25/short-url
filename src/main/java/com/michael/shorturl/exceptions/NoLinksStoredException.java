package com.michael.shorturl.exceptions;

public class NoLinksStoredException extends RuntimeException{
    public NoLinksStoredException(){
        super("No links stored");
    }
}
