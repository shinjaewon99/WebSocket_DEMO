package com.websocket.web_socket.message.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

    private final JavaMailSender javaMailSender;

    @Scheduled(fixedRate = 300000) // 5분마다 실행 (5 * 60 * 1000ms)
    public void sendScheduledMail() {
        log.info("5분마다 메일 전송 시작...");
        sendSimpleMailMessage();
    }

    public void sendSimpleMailMessage() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo("tlswodnjs99@gmail.com");  // 수신자 이메일
            message.setSubject("정기 주식 알림");
            message.setText("현재 주식 정보를 확인하세요!");

            javaMailSender.send(message);
            log.info("메일 전송 완료!");
        } catch (Exception e) {
            log.error("메일 전송 실패", e);
        }
    }
}

