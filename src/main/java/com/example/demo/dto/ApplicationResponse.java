package com.example.demo.dto;

import java.time.LocalDate;

public class ApplicationResponse {

    private Long applicationId;
    private Long candidateId;
    private Long jobId;

    private String candidateName;
    private String email;
    private String jobTitle;
    private LocalDate appliedDate;

    // AI Scores
    private Double matchScore;
    private Double technicalScore;
    private Double communicationScore;
    private Double overallScore;
    private String aiFeedback;

    // Status
    private String interviewStatus;
    private String finalStatus;

    public ApplicationResponse() {
    }

    public ApplicationResponse(Long applicationId,
                               Long candidateId,
                               Long jobId,
                               String candidateName,
                               String email,
                               String jobTitle,
                               LocalDate appliedDate,
                               Double matchScore,
                               Double technicalScore,
                               Double communicationScore,
                               Double overallScore,
                               String aiFeedback,
                               String interviewStatus,
                               String finalStatus) {

        this.applicationId = applicationId;
        this.candidateId = candidateId;
        this.jobId = jobId;
        this.candidateName = candidateName;
        this.email = email;
        this.jobTitle = jobTitle;
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

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
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