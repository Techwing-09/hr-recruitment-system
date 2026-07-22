package com.example.demo.dto;

public class ApplicationRequest {

    private Long candidateId;
    private Long jobId;

    public ApplicationRequest() {
    }

    public ApplicationRequest(Long candidateId, Long jobId) {
        this.candidateId = candidateId;
        this.jobId = jobId;
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
}