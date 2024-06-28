package com.assignment.springbootcrud.service;

import com.assignment.springbootcrud.model.User;

import java.util.List;

public interface RegistrationService {

    User getUserById(Long userId);
    User createUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    List<User> getAllUsers();
}
