package com.websocket.web_socket.message.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockInfoDto {
    private String stockId;
    private Integer price;

    private String user;
    private String message;
}
