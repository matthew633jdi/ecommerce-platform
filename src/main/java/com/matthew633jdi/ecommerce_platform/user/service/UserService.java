package com.matthew633jdi.ecommerce_platform.user.service;

import com.matthew633jdi.ecommerce_platform.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
}
