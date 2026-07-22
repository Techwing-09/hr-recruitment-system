package com.example.demo.dto;

public class LoginResponse {

    private String message;
    private Long userId;
    private String fullName;
    private String role;

    public LoginResponse() {
    }

    public LoginResponse(String message, Long userId, String fullName, String role) {
        this.message = message;
        this.userId = userId;
        this.fullName = fullName;
        this.role = role;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}