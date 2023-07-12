package com.loginFlow.userLoginTest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loginFlow.userLoginTest.dto.UserLoginDto;
import com.loginFlow.userLoginTest.dto.UserSignupDto;
import com.loginFlow.userLoginTest.repository.UserRepository;
import com.loginFlow.userLoginTest.service.AuthService;
import com.loginFlow.userLoginTest.utils.ResponseHandler;

@RestController
@RequestMapping("/api/v1/")

public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("signup")
    public ResponseEntity<Object> singup(@RequestBody UserSignupDto request) {
        // return ResponseHandler.generateResponse("Successfull", HttpStatus.OK, null);
        try {
            String message = authService.signup(request);
            return ResponseHandler.generateResponse(message, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }



    @PostMapping("login")
    public ResponseEntity<Object> login(@RequestBody UserLoginDto request) {
        try {
            String message = authService.login(request);
            return ResponseHandler.generateResponse(message, HttpStatus.OK, null);
        } catch (Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
