package com.user.service.UserService.controller;

import com.user.service.UserService.entities.User;
import com.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User saveUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId) {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAllUser();
        return ResponseEntity.ok(userList);
    }
}
