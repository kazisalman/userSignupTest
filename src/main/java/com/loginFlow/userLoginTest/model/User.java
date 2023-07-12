package com.loginFlow.userLoginTest.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name = "customer")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    private String email;
    private String password;
    private String mobile;
    private Integer verified;
    private Integer otp;


    public User(String email, String name, String password, String mobile, Integer verified,Integer otp) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
        this.verified = verified;
        this.otp = otp;

    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getmobile() {
        return mobile;
    }

    public void setmobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getVerified() {
        return verified;
    }

    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    public Integer getOtp() {
        return otp;
    }

    public void setOtp(Integer otp) {
        this.otp = otp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(name, user.name)
                && Objects.equals(password, user.password) && Objects.equals(mobile, user.mobile) 
                && Objects.equals(verified, user.verified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, password, mobile,verified);
    }

    @Override
    public String toString() {
        return "products{" +
                "email=" + email +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", mobile=" + mobile +
                ", verified=" + verified +

                '}';
    }

}
