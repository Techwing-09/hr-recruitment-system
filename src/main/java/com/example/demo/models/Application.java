package com.example.demo.models;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "resume_id", nullable = false)
    private Resume resume;

    @Column(nullable = false)
    private LocalDate appliedDate;

    // AI Generated Scores
    private Double matchScore;

    private Double technicalScore;

    private Double communicationScore;

    private Double overallScore;

    @Column(columnDefinition = "TEXT")
    private String aiFeedback;

    // Status
    private String interviewStatus;

    private String finalStatus;

    public Application() {
    }

    public Application(Long applicationId, Candidate candidate, Job job,
            Resume resume, LocalDate appliedDate,
            Double matchScore,
            Double technicalScore,
            Double communicationScore,
            Double overallScore,
            String aiFeedback,
            String interviewStatus,
            String finalStatus) {

        this.applicationId = applicationId;
        this.candidate = candidate;
        this.job = job;
        this.resume = resume;
        this.appliedDate = appliedDate;
        this.matchScore = matchScore;
        this.technicalScore = technicalScore;
        this.communicationScore = communicationScore;
        this.overallScore = overallScore;
        this.aiFeedback = aiFeedback;
        this.interviewStatus = interviewStatus;
        this.finalStatus = finalStatus;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Resume getResume() {
        return resume;
    }

    public void setResume(Resume resume) {
        this.resume = resume;
    }

    public LocalDate getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(LocalDate appliedDate) {
        this.appliedDate = appliedDate;
    }

    public Double getMatchScore() {
        return matchScore;
    }

    public void setMatchScore(Double matchScore) {
        this.matchScore = matchScore;
    }

    public Double getTechnicalScore() {
        return technicalScore;
    }

    public void setTechnicalScore(Double technicalScore) {
        this.technicalScore = technicalScore;
    }

    public Double getCommunicationScore() {
        return communicationScore;
    }

    public void setCommunicationScore(Double communicationScore) {
        this.communicationScore = communicationScore;
    }

    public Double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }

    public String getAiFeedback() {
        return aiFeedback;
    }

    public void setAiFeedback(String aiFeedback) {
        this.aiFeedback = aiFeedback;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getFinalStatus() {
        return finalStatus;
    }

    public void setFinalStatus(String finalStatus) {
        this.finalStatus = finalStatus;
    }
}