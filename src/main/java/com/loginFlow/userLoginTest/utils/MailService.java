package com.loginFlow.userLoginTest.utils;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.loginFlow.userLoginTest.model.User;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendVerificationEmail(User user, String otp)
            throws MessagingException, UnsupportedEncodingException {
        String toAddress = user.getEmail();
        String fromAddress = "SalmanBitw434@gmail.com";
        String senderName = "Your company name";
        String subject = "Verification code";
        String content = "Dear [[name]],<br>"
                + "Your verification code is:<br>"
                // + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>"
                + "<h3>[[URL]]</h3>"
                + "Thank you,<br>"
                + "Your company name.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", user.getName());
        String verifyURL = otp + "/verify?code=" + user.getEmail();

        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);


    }

}
