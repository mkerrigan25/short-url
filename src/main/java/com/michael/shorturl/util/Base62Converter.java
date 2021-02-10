package com.michael.shorturl.util;


public class Base62Converter {

    //base62 is used to give each short url an unique link.
    public static final String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public char[] characterArray = characters.toCharArray();

    public String toBase62(Integer id){
            String result ="";
            while (id > 0) {
                id--;
                result = characterArray[(id % 62)] + result;
                id = id / 62;
            }
        return "http://localhost:8080/" + result;
    }

    public int toBase10(String encodedString){
        int result = 0;
        for(char a: encodedString.toCharArray()){
            result= result*62 + (characters.indexOf(a)+1);
        }
        return result;
    }
}
