package com.loginFlow.userLoginTest.dto;

public record UserSignupDto(
        String name,
        String email,
        String password,
        String mobile,
        Integer verified,
        Integer otp
        ) {

}
