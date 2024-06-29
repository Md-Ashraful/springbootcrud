package com.assignment.springbootcrud.service;

import com.assignment.springbootcrud.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RegistrationService {

    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    Page<User> getAllUsers(Pageable pageable);
}
