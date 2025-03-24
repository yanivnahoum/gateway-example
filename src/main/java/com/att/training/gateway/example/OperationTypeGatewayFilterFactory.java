package com.att.training.gateway.example;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

@Component
public class OperationTypeGatewayFilterFactory extends AbstractGatewayFilterFactory<OperationTypeGatewayFilterFactory.Config> {

    public static final String OPERATION_TYPE_ATTR = "com.att.training.gateway.example.operationType";

    public OperationTypeGatewayFilterFactory() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(OPERATION_TYPE_ATTR, "HELLO");
            return chain.filter(exchange);
        };
    }

    public static class Config {
        String operationType;
    }

}
