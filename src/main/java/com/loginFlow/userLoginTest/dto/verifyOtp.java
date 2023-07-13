package com.loginFlow.userLoginTest.dto;

public record verifyOtp(
    String email,
    String mobile,
    Integer otp
) {
    
}
