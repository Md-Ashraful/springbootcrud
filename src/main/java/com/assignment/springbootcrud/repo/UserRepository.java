package com.assignment.springbootcrud.repo;

import com.assignment.springbootcrud.model.User;
import jakarta.annotation.Nonnull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    Optional<User> findByUserId(String username);

    Page<User> findAll(@Nonnull Pageable pageable);
}
