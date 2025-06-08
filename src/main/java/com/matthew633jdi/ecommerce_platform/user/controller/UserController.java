package com.matthew633jdi.ecommerce_platform.user.controller;

import com.matthew633jdi.ecommerce_platform.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    public final UserService userService;


}
