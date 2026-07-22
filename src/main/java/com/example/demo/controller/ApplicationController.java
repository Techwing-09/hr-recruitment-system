package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "http://localhost:4200")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Candidate Apply Job
    @PostMapping("/apply")
    public String applyJob(@RequestBody ApplicationRequest request) {
        return applicationService.applyJob(request);
    }

    // Get All Applications
    @GetMapping
    public List<ApplicationResponse> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // Get Application By Id
    @GetMapping("/{applicationId}")
    public ApplicationResponse getApplicationById(@PathVariable Long applicationId) {
        return applicationService.getApplicationById(applicationId);
    }

    // Get Applications By Candidate Id
    @GetMapping("/candidate/{candidateId}")
    public List<ApplicationResponse> getApplicationsByCandidate(@PathVariable Long candidateId) {
        return applicationService.getApplicationsByCandidate(candidateId);
    }

    // Get Applications By Job Id
    @GetMapping("/job/{jobId}")
    public List<ApplicationResponse> getApplicationsByJob(@PathVariable Long jobId) {
        return applicationService.getApplicationsByJob(jobId);
    }

    // Send Offer
    @PutMapping("/{applicationId}/offer")
    public String sendOffer(@PathVariable Long applicationId) {
        return applicationService.sendOffer(applicationId);
    }

    // Reject Candidate
    @PutMapping("/{applicationId}/reject")
    public String rejectCandidate(@PathVariable Long applicationId) {
        return applicationService.rejectCandidate(applicationId);
    }

    // Delete Application
    @DeleteMapping("/{applicationId}")
    public String deleteApplication(@PathVariable Long applicationId) {
        return applicationService.deleteApplication(applicationId);
    }

}