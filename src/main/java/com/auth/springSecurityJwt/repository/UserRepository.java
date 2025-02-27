package com.auth.springSecurityJwt.repository;


import com.auth.springSecurityJwt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}

