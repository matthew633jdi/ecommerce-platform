package com.matthew633jdi.ecommerce_platform.user.repository;

import com.matthew633jdi.ecommerce_platform.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
