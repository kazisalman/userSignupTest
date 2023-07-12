package com.loginFlow.userLoginTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan() // Add the package containing MailService
public class UserLoginTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserLoginTestApplication.class, args);
	}

}
