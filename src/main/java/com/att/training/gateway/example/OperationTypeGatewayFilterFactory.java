package com.att.training.gateway.example;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationTypeGatewayFilterFactory extends AbstractGatewayFilterFactory<AbstractGatewayFilterFactory.NameConfig> {
    public static final String OPERATION_TYPE_ATTR = "com.att.training.gateway.example.operationType";

    public OperationTypeGatewayFilterFactory() {
        super(NameConfig.class);
    }

    @Override
    public GatewayFilter apply(NameConfig config) {
        return (exchange, chain) -> {
            exchange.getAttributes().put(OPERATION_TYPE_ATTR, config.getName());
            return chain.filter(exchange);
        };
    }

    @Override
    public List<String> shortcutFieldOrder() {
        return List.of(NAME_KEY);
    }
}
