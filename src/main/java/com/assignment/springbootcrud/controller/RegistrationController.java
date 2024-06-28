package com.assignment.springbootcrud.controller;

import com.assignment.springbootcrud.model.User;
import com.assignment.springbootcrud.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public ResponseEntity<?> getUsers(){
        var users = registrationService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK
        );
    }

    @PostMapping("/registration")
    public ResponseEntity<?> registerUser( @RequestBody User userInfo){

        var response = registrationService.createUser(userInfo);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }
}
