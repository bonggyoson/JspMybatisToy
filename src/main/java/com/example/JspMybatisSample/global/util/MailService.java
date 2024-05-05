package com.example.JspMybatisSample.global.util;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bonggyoson@gmail.com");
        message.setTo("bonggyoson@gmail.com");
        message.setSubject(subject);
        message.setText("임시 비밀번호는 " + text + " 입니다.");
        javaMailSender.send(message);

    }


}
