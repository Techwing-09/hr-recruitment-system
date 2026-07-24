package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ai.AIService;
import com.example.demo.dto.ApplicationRequest;
import com.example.demo.dto.ApplicationResponse;
import com.example.demo.models.Application;
import com.example.demo.models.Candidate;
import com.example.demo.models.Job;
import com.example.demo.models.Resume;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.JobRepository;
import com.example.demo.repository.ResumeRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private AIService aiService;

    // Apply Job
    public String applyJob(ApplicationRequest request) {

        if (applicationRepository.existsByCandidate_IdAndJob_Id(
                request.getCandidateId(),
                request.getJobId())) {

            return "You have already applied for this job.";
        }

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        Job job = jobRepository.findById(request.getJobId())
                .orElseThrow(() -> new RuntimeException("Job not found"));

        Resume resume = resumeRepository.findByCandidateId(request.getCandidateId())
                .orElseThrow(() -> new RuntimeException("Resume not found"));

        Application application = new Application();

        application.setCandidate(candidate);
        application.setJob(job);
        application.setResume(resume);
        application.setAppliedDate(LocalDate.now());

        // Default Interview Scores
        application.setTechnicalScore(0.0);
        application.setCommunicationScore(0.0);
        application.setOverallScore(0.0);

        // Save application first
        applicationRepository.save(application);

        // Call Python GenAI Match API
        aiService.generateMatchScore(application, resume, job);

        // Save updated AI values
        applicationRepository.save(application);

        return "Application Submitted Successfully";
    }

    // Get All Applications
    public List<ApplicationResponse> getAllApplications() {

        List<Application> applications = applicationRepository.findAll();

        List<ApplicationResponse> response = new ArrayList<>();

        for (Application application : applications) {

            ApplicationResponse dto = new ApplicationResponse();

            dto.setApplicationId(application.getApplicationId());
            dto.setCandidateId(application.getCandidate().getId());
            dto.setJobId(application.getJob().getId());
            dto.setCandidateName(application.getCandidate().getCandidateName());
            dto.setEmail(application.getCandidate().getEmail());
            dto.setJobTitle(application.getJob().getJobTitle());
            dto.setAppliedDate(application.getAppliedDate());
            dto.setMatchScore(application.getMatchScore());
            dto.setTechnicalScore(application.getTechnicalScore());
            dto.setCommunicationScore(application.getCommunicationScore());
            dto.setOverallScore(application.getOverallScore());
            dto.setAiFeedback(application.getAiFeedback());
            dto.setInterviewStatus(application.getInterviewStatus());
            dto.setFinalStatus(application.getFinalStatus());

            response.add(dto);
        }

        return response;
    }

    // Get Application By Id
    public ApplicationResponse getApplicationById(Long applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application Not Found"));

        ApplicationResponse dto = new ApplicationResponse();

        dto.setApplicationId(application.getApplicationId());
        dto.setCandidateId(application.getCandidate().getId());
        dto.setJobId(application.getJob().getId());
        dto.setCandidateName(application.getCandidate().getCandidateName());
        dto.setEmail(application.getCandidate().getEmail());
        dto.setJobTitle(application.getJob().getJobTitle());
        dto.setAppliedDate(application.getAppliedDate());
        dto.setMatchScore(application.getMatchScore());
        dto.setTechnicalScore(application.getTechnicalScore());
        dto.setCommunicationScore(application.getCommunicationScore());
        dto.setOverallScore(application.getOverallScore());
        dto.setAiFeedback(application.getAiFeedback());
        dto.setInterviewStatus(application.getInterviewStatus());
        dto.setFinalStatus(application.getFinalStatus());

        return dto;
    }

    // Get Applications By Candidate
    public List<ApplicationResponse> getApplicationsByCandidate(Long candidateId) {

        List<Application> applications = applicationRepository.findByCandidate_Id(candidateId);

        List<ApplicationResponse> response = new ArrayList<>();

        for (Application application : applications) {

            ApplicationResponse dto = new ApplicationResponse();

            dto.setApplicationId(application.getApplicationId());
            dto.setCandidateId(application.getCandidate().getId());
            dto.setJobId(application.getJob().getId());
            dto.setCandidateName(application.getCandidate().getCandidateName());
            dto.setEmail(application.getCandidate().getEmail());
            dto.setJobTitle(application.getJob().getJobTitle());
            dto.setAppliedDate(application.getAppliedDate());
            dto.setMatchScore(application.getMatchScore());
            dto.setTechnicalScore(application.getTechnicalScore());
            dto.setCommunicationScore(application.getCommunicationScore());
            dto.setOverallScore(application.getOverallScore());
            dto.setAiFeedback(application.getAiFeedback());
            dto.setInterviewStatus(application.getInterviewStatus());
            dto.setFinalStatus(application.getFinalStatus());

            response.add(dto);
        }

        return response;
    }

    // Get Applications By Job
    public List<ApplicationResponse> getApplicationsByJob(Long jobId) {

        List<Application> applications = applicationRepository.findByJob_Id(jobId);

        List<ApplicationResponse> response = new ArrayList<>();

        for (Application application : applications) {

            ApplicationResponse dto = new ApplicationResponse();

            dto.setApplicationId(application.getApplicationId());
            dto.setCandidateId(application.getCandidate().getId());
            dto.setJobId(application.getJob().getId());
            dto.setCandidateName(application.getCandidate().getCandidateName());
            dto.setEmail(application.getCandidate().getEmail());
            dto.setJobTitle(application.getJob().getJobTitle());
            dto.setAppliedDate(application.getAppliedDate());
            dto.setMatchScore(application.getMatchScore());
            dto.setTechnicalScore(application.getTechnicalScore());
            dto.setCommunicationScore(application.getCommunicationScore());
            dto.setOverallScore(application.getOverallScore());
            dto.setAiFeedback(application.getAiFeedback());
            dto.setInterviewStatus(application.getInterviewStatus());
            dto.setFinalStatus(application.getFinalStatus());

            response.add(dto);
        }

        return response;
    }

    // Send Offer
    public String sendOffer(Long applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application Not Found"));

        application.setFinalStatus("Offer Sent");

        applicationRepository.save(application);

        return "Offer sent successfully.";
    }

    // Reject Candidate
    public String rejectCandidate(Long applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application Not Found"));

        application.setFinalStatus("Rejected");

        applicationRepository.save(application);

        return "Candidate rejected successfully.";
    }

    // Delete Application
    public String deleteApplication(Long applicationId) {

        Application application = applicationRepository.findById(applicationId)
                .orElseThrow(() -> new RuntimeException("Application Not Found"));

        applicationRepository.delete(application);

        return "Application Deleted Successfully";
    }
}