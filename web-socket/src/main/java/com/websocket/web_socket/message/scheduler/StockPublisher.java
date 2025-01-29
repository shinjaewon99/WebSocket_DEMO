package com.websocket.web_socket.message.scheduler;

import com.websocket.web_socket.message.dto.StockInfoDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class StockPublisher {

    private final RedisTemplate redisTemplate;

    @Scheduled(fixedRate = 5000)
    public void publishStock() {
        log.info("주식 가격 발행");
        redisTemplate.convertAndSend("stock", getStockInfo());
    }

    private StockInfoDto getStockInfo() {
        return StockInfoDto.builder()
                .stockId("apple")
                .price(2000)
                .build();
    }
}
