package com.sl.ecom.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sl.ecom.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String email);
}
