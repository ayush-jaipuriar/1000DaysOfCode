package com.drarc.gatewayserver.filters;

import org.springframework.http.HttpHeaders;
import org.springframework.web.server.ServerWebExchange;

import java.util.List;
import java.util.UUID;

public class FilterUtility {

    public static final String CORRELATION_ID = "ayush-drarc-correlation-id";

    public static String getCorrelationId(HttpHeaders requestHeaders) {
        if (requestHeaders.get(CORRELATION_ID) != null) {
            List<String> requestHeaderList = requestHeaders.get(CORRELATION_ID);
            return requestHeaderList.stream().findFirst().orElse(null);
        } else {
            return null;
        }
    }
    
    public static boolean isCorrelationIdPresent(HttpHeaders requestHeaders) {
        return getCorrelationId(requestHeaders) != null;
    }

    public static ServerWebExchange setRequestHeader(ServerWebExchange exchange, String name, String value) {
        return exchange.mutate().request(exchange.getRequest().mutate().header(name, value).build()).build();
    }

    public ServerWebExchange setCorrelationId(ServerWebExchange exchange) {
        HttpHeaders requestHeaders = exchange.getRequest().getHeaders();
        if (getCorrelationId(requestHeaders) != null) {
            return exchange;
        } else {
            String correlationID = generateCorrelationId();
            return setRequestHeader(exchange, CORRELATION_ID, correlationID);
        }
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }

} 