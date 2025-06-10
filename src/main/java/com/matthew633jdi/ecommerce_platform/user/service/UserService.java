package com.matthew633jdi.ecommerce_platform.user.service;

import com.matthew633jdi.ecommerce_platform.common.exception.AlreadyExistsEmailException;
import com.matthew633jdi.ecommerce_platform.user.domain.User;
import com.matthew633jdi.ecommerce_platform.user.dto.SignupRequest;
import com.matthew633jdi.ecommerce_platform.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User signup(SignupRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new AlreadyExistsEmailException();
        }

        User user = User.builder()
                .email(request.email())
                .name(request.name())
                .password(request.password())
                .build();
        return userRepository.save(user);
    }
}
