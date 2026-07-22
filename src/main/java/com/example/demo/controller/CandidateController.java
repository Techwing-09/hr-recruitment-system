package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.models.Candidate;
import com.example.demo.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    // ==========================
    // Candidate Signup
    // ==========================
    @PostMapping("/signup")
    public CandidateSignupResponse signup(@RequestBody CandidateSignupRequest request) {
        return candidateService.signup(request);
    }

    // ==========================
    // Candidate Login
    // ==========================
    @PostMapping("/login")
    public CandidateLoginResponse login(@RequestBody CandidateLoginRequest request) {
        return candidateService.login(request);
    }

    // ==========================
    // Forgot Password
    // ==========================
    @PutMapping("/forgot-password")
    public String resetPassword(@RequestBody ForgotPasswordRequest request) {
        return candidateService.resetPassword(request);
    }

    // ==========================
    // Get All Candidates
    // ==========================
    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    // ==========================
    // Get Candidate By Id
    // ==========================
    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return candidateService.getCandidateById(id);
    }

    // ==========================
    // Update Candidate
    // ==========================
    @PutMapping("/{id}")
    public Candidate updateCandidate(@PathVariable Long id,
                                     @RequestBody Candidate candidate) {
        return candidateService.updateCandidate(id, candidate);
    }

    // ==========================
    // Delete Candidate
    // ==========================
    @DeleteMapping("/{id}")
    public String deleteCandidate(@PathVariable Long id) {
        return candidateService.deleteCandidate(id);
    }
}