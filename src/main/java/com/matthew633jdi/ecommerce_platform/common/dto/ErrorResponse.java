package com.matthew633jdi.ecommerce_platform.common.dto;

public record ErrorResponse(String message) {
    public static ErrorResponse of(String message) {
        return new ErrorResponse(message);
    }
}
