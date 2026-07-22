package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ForgotPasswordRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.SignupRequest;
import com.example.demo.dto.SignupResponse;
import com.example.demo.models.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    // ==========================
    // HR Signup
    // ==========================
    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        return userService.signup(request);
    }

    // ==========================
    // HR Login
    // ==========================
    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return userService.login(request);
    }

    // ==========================
    // HR Forgot Password
    // ==========================
    @PutMapping("/forgot-password")
    public String resetPassword(@RequestBody ForgotPasswordRequest request) {
        return userService.resetPassword(request);
    }

    // ==========================
    // Get HR Profile
    // ==========================
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // ==========================
    // Update HR Profile
    // ==========================
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id,
                           @RequestBody User user) {

        return userService.updateUser(id, user);
    }
}