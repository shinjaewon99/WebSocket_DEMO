package com.websocket.web_socket.message.sender;

import com.websocket.web_socket.message.dto.StockInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageSender {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendMessage() {
        messagingTemplate.convertAndSend("/sub/stocks", getStockInfo("nvidia", 2000));
    }

    public StockInfoDto getStockInfo(String stockId, int price) {
        return StockInfoDto.builder()
                .stockId(stockId)
                .price(price)
                .build();
    }
}