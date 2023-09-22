package com.example.labofinal.services.impl;

import com.example.labofinal.services.EmailService;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
@Service
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendVerificationCode(String toEmail, String verificationCode) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toEmail);
        mailMessage.setSubject("Code de vérification");
        mailMessage.setText("Votre code de vérification est : " + verificationCode);
        System.out.println(toEmail + " --- " + verificationCode + "--- testEmail");
        javaMailSender.send(mailMessage);
    }
}
