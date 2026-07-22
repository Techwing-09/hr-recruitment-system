package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ForgotPasswordRequest;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import com.example.demo.dto.SignupRequest;
import com.example.demo.dto.SignupResponse;
import com.example.demo.exception.InvalidCredentialsException;
import com.example.demo.exception.UserAlreadyExistsException;
import com.example.demo.models.User;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    // ==========================
    // HR Signup
    // ==========================
    public SignupResponse signup(SignupRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists as HR.");
        }

        if (candidateRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException("This email is already registered as Candidate.");
        }

        if (userRepository.findByPhone(request.getPhone()).isPresent()) {
            throw new UserAlreadyExistsException("Phone number already exists.");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setCompanyName(request.getCompanyName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());

        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        return new SignupResponse("HR Registered Successfully.");
    }

    // ==========================
    // HR Login
    // ==========================
    public LoginResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new InvalidCredentialsException("Invalid Email"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new InvalidCredentialsException("Invalid Password");
        }

        return new LoginResponse(
                "Login Successful",
                user.getId(),
                user.getFullName(),
                user.getRole());
    }

    // ==========================
    // HR Forgot Password
    // ==========================
    public String resetPassword(ForgotPasswordRequest request) {

        Optional<User> optionalUser =
                userRepository.findByEmail(request.getEmail());

        if (optionalUser.isEmpty()) {
            return "Email not found";
        }

        User user = optionalUser.get();

        user.setPassword(request.getNewPassword());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);

        return "Password Updated Successfully";
    }

    // ==========================
    // Get HR Profile
    // ==========================
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

    }

    // ==========================
    // Update HR Profile
    // ==========================
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        user.setFullName(updatedUser.getFullName());
        user.setCompanyName(updatedUser.getCompanyName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

        // Keep existing password and role unchanged
        user.setPassword(user.getPassword());
        user.setRole(user.getRole());

        user.setUpdatedAt(LocalDateTime.now());

        return userRepository.save(user);
    }

}