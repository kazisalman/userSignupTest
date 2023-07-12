package com.loginFlow.userLoginTest.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginFlow.userLoginTest.dto.UserLoginDto;
import com.loginFlow.userLoginTest.dto.UserSignupDto;
import com.loginFlow.userLoginTest.model.User;
import com.loginFlow.userLoginTest.repository.UserRepository;
import com.loginFlow.userLoginTest.utils.MailService;

import jakarta.mail.MessagingException;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    public AuthService(MailService mailService) {
        this.mailService = mailService;
    }

    // ALTERNATE METHOD
    // public AuthService(UserRepository userRepository) {
    // this.userRepository = userRepository;
    // }

    public String signup(UserSignupDto request) {
        List<User> customers = userRepository.findByEmail(request.email());
        System.out.println(customers);

        if (customers.size() > 0) {
            return "User with same email already exist";
        }

        try {
            User user = new User();
            Random random = new Random();
            String code = String.format("%04d", random.nextInt(10000));

            Integer otp = Integer.parseInt(code);

            user.setEmail(request.email());
            user.setName(request.name());
            user.setmobile(request.mobile());
            user.setPassword(request.password());
            user.setVerified(0);
            user.setOtp(otp);
            userRepository.save(user);

            mailService.sendVerificationEmail(user, code);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "Signup successfull";

    }

    public String login(UserLoginDto request) {

        if (request.type().equals("email")) {
            List<User> customers = userRepository.findByEmail(request.email());

            System.out.println(customers);

            if (customers.isEmpty()) {
                return "User doesn't exist";
            } else {
                User user = customers.get(0);

                System.out.println("User: " + user.getName());
                System.out.println("Verified: " + user.getVerified());
                if (user != null && user.getVerified() != null && user.getVerified() == 1) {
                    return "Logged in";
                } else {
                    return "User exists but not verified";
                }
            }
        }

        
        List<User> customers = userRepository.findByMobile(request.mobile());
        if (customers.isEmpty()) {
            return "User doesn't exist";
        } else {
            User user = customers.get(0);

            System.out.println("User: " + user.getName());
            System.out.println("Verified: " + user.getVerified());
            if (user != null && user.getVerified() != null && user.getVerified() == 1) {
                return "Logged in";
            } else {
                return "User exists but not verified";
            }
        }

    }

}
