package com.att.training.gateway.example;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.Map;

@Component
public class ExtendedErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(request, options);
        String operationType = request.exchange().getAttribute(OperationTypeGatewayFilterFactory.OPERATION_TYPE_ATTR);
        errorAttributes.put("operationType", operationType);
        return errorAttributes;
    }
}
