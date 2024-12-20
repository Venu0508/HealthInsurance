package com.healthinsurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthinsurance.serviceimp.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/otp")
public class OtpController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/send-otp")
    public String sendOtp(@RequestParam String email) {
        String otp = emailService.generateOTP();
        try {
            emailService.sendOtpEmail(email, otp);
            return "OTP sent to " + email;
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Failed to send OTP. Please try again.";
        }
    }
   
}
