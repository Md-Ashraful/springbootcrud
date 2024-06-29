package com.assignment.springbootcrud.controller;

import com.assignment.springbootcrud.model.User;
import com.assignment.springbootcrud.service.RegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;


    @PostMapping("/registration")
    @Operation(summary = "To register new user.",description = "Use to register new user.")
    public ResponseEntity<?> registerUser( @RequestBody User userInfo){

        var response = registrationService.createUser(userInfo);

        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

    @GetMapping
    @Operation(summary = "To get list of user.",description = "Use to get list of registers users. Support dynamic sorting, pageable.")
    public ResponseEntity<Page<User>> getUsers(@ParameterObject @PageableDefault Pageable pageable){
        var users = registrationService.getAllUsers(pageable);
        return new ResponseEntity<>(users,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "To get user by userId.",description = "Show users details by userId")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id){
        var user = registrationService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Operation(summary = "To update existing user.",description = "Use to update register existing user.")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody User userInfo){
        var user = registrationService.updateUser(id,userInfo);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "To delete user.",description = "Use to delete specific user.")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        registrationService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
