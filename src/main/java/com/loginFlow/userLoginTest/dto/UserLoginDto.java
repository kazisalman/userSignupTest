package com.loginFlow.userLoginTest.dto;

public record UserLoginDto(
        String email,
        String password,
        String mobile, 
        String type
        ) {

}
