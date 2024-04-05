package com.example.JspMybatisSample.global.util;

import lombok.NoArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("bonggyoson@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText("임시 비밀번호는 " + text + " 입니다.");
//        javaMailSender.send(message);

    }


}
