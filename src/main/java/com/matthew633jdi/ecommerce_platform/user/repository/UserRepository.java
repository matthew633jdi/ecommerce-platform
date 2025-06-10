package com.matthew633jdi.ecommerce_platform.user.repository;

import com.matthew633jdi.ecommerce_platform.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
