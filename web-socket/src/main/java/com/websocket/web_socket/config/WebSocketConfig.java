package com.websocket.web_socket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/sub"); // 특정 토픽을 구독
        registry.setApplicationDestinationPrefixes("/pub");    // 메시지를 발행
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/stomp")
//                .setAllowedOriginPatterns("*")
//                .withSockJS();

        // 테스트 시 에러로 인하여 .withSockJs() 제외 엔드포인트 추가
        // 실제 환경에선 불필요
        registry.addEndpoint("/stomp")
                .setAllowedOriginPatterns("*");
    }
}
