package com.example.demo.service;

import com.example.demo.dto.*;
import com.example.demo.models.Candidate;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    // ==========================
    // Candidate Signup
    // ==========================
    public CandidateSignupResponse signup(CandidateSignupRequest request) {

        CandidateSignupResponse response = new CandidateSignupResponse();

        if (candidateRepository.existsByEmail(request.getEmail())) {
            response.setMessage("Email already exists as Candidate");
            return response;
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            response.setMessage("This email is already registered as HR");
            return response;
        }

        if (candidateRepository.existsByPhone(request.getPhone())) {
            response.setMessage("Phone already exists");
            return response;
        }

        Candidate candidate = new Candidate();

        candidate.setCandidateName(request.getCandidateName());
        candidate.setEmail(request.getEmail());
        candidate.setPhone(request.getPhone());
        candidate.setPassword(request.getPassword());

        Candidate saved = candidateRepository.save(candidate);

        response.setId(saved.getId());
        response.setCandidateName(saved.getCandidateName());
        response.setEmail(saved.getEmail());
        response.setPhone(saved.getPhone());
        response.setMessage("Candidate Registered Successfully");

        return response;
    }

    // ==========================
    // Candidate Login
    // ==========================
    public CandidateLoginResponse login(CandidateLoginRequest request) {

        CandidateLoginResponse response = new CandidateLoginResponse();

        Optional<Candidate> optionalCandidate =
                candidateRepository.findByEmail(request.getEmail());

        if (optionalCandidate.isEmpty()) {
            response.setMessage("Candidate not found");
            return response;
        }

        Candidate candidate = optionalCandidate.get();

        if (!candidate.getPassword().equals(request.getPassword())) {
            response.setMessage("Invalid Password");
            return response;
        }

        response.setId(candidate.getId());
        response.setCandidateName(candidate.getCandidateName());
        response.setEmail(candidate.getEmail());
        response.setPhone(candidate.getPhone());
        response.setMessage("Login Successful");

        return response;
    }

    // ==========================
    // Get All Candidates
    // ==========================
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // ==========================
    // Get Candidate By Id
    // ==========================
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // ==========================
    // Update Candidate
    // ==========================
    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {

        System.out.println("====================================");
        System.out.println("Qualification : " + updatedCandidate.getQualification());
        System.out.println("Skills        : " + updatedCandidate.getSkills());
        System.out.println("Experience    : " + updatedCandidate.getExperience());
        System.out.println("Address       : " + updatedCandidate.getAddress());
        System.out.println("====================================");

        Optional<Candidate> optionalCandidate =
                candidateRepository.findById(id);

        if (optionalCandidate.isPresent()) {

            Candidate candidate = optionalCandidate.get();

            candidate.setCandidateName(updatedCandidate.getCandidateName());
            candidate.setEmail(updatedCandidate.getEmail());
            candidate.setPhone(updatedCandidate.getPhone());

            if (updatedCandidate.getPassword() != null &&
                    !updatedCandidate.getPassword().isEmpty()) {
                candidate.setPassword(updatedCandidate.getPassword());
            }

            candidate.setQualification(updatedCandidate.getQualification());
            candidate.setSkills(updatedCandidate.getSkills());
            candidate.setExperience(updatedCandidate.getExperience());
            candidate.setAddress(updatedCandidate.getAddress());

            Candidate savedCandidate = candidateRepository.save(candidate);

            System.out.println("Saved Qualification : " + savedCandidate.getQualification());
            System.out.println("Saved Skills        : " + savedCandidate.getSkills());
            System.out.println("Saved Experience    : " + savedCandidate.getExperience());
            System.out.println("Saved Address       : " + savedCandidate.getAddress());

            return savedCandidate;
        }

        return null;
    }

    // ==========================
    // Delete Candidate
    // ==========================
    public String deleteCandidate(Long id) {

        if (candidateRepository.existsById(id)) {
            candidateRepository.deleteById(id);
            return "Candidate Deleted Successfully";
        }

        return "Candidate Not Found";
    }

    // ==========================
    // Forgot Password
    // ==========================
    public String resetPassword(ForgotPasswordRequest request) {

        Optional<Candidate> optionalCandidate =
                candidateRepository.findByEmail(request.getEmail());

        if (optionalCandidate.isEmpty()) {
            return "Email not found";
        }

        Candidate candidate = optionalCandidate.get();

        candidate.setPassword(request.getNewPassword());

        candidateRepository.save(candidate);

        return "Password Updated Successfully";
    }
}