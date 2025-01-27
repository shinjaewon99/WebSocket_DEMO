package com.websocket.web_socket.message.scheduler;

import com.websocket.web_socket.message.sender.MessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageScheduler {

    private final MessageSender messageSender;

    @Scheduled(fixedRate = 10000) // 10000ms = 10 second
    public void scheduleMessage() {
        log.info("Message scheduled");
        messageSender.sendMessage();
    }
}
