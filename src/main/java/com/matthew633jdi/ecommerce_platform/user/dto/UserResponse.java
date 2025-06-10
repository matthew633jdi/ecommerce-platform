package com.matthew633jdi.ecommerce_platform.user.dto;

import com.matthew633jdi.ecommerce_platform.user.domain.User;

public record UserResponse(Long id, String email, String name) {
    public static UserResponse from(User user) {
        return new UserResponse(user.getId(), user.getEmail(), user.getName());
    }
}
