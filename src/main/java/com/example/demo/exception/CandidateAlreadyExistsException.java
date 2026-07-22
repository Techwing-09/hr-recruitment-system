package com.example.demo.exception;

public class CandidateAlreadyExistsException extends RuntimeException {

    public CandidateAlreadyExistsException(String message) {
        super(message);
    }
}