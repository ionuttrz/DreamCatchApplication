package com.ProiectareSoftware.dreamCatch.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DreamCatchUtils {

    public DreamCatchUtils() {
    }

    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>(
                "{\"message\": \""+responseMessage+"\"}",
                httpStatus);
    }
}
