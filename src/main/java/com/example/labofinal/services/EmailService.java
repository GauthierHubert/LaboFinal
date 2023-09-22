package com.example.labofinal.services;

public interface EmailService {
    void sendVerificationCode(String toEmail, String verificationCode);
}
