package com.loginFlow.userLoginTest.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus status, Object responseObj) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        map.put("status", status.value());
        map.put("data", responseObj);
        // map.put("code", code.orElse(1)); // Use the default value of 1 if code is not provided

        // String value = optionalParam.orElse("default value");


        return new ResponseEntity<Object>(map,status);
    }
}