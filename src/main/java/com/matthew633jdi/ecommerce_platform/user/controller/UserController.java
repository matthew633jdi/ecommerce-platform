package com.matthew633jdi.ecommerce_platform.user.controller;

import com.matthew633jdi.ecommerce_platform.user.domain.User;
import com.matthew633jdi.ecommerce_platform.user.dto.SignupRequest;
import com.matthew633jdi.ecommerce_platform.user.dto.UserResponse;
import com.matthew633jdi.ecommerce_platform.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/signup", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse signup(@RequestBody @Valid SignupRequest request) {
        User user = userService.signup(request);
        return UserResponse.from(user);
    }
}
