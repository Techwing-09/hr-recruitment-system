package com.example.demo.dto;

public class CandidateDashboardResponse {

    private long availableJobs;
    private long appliedJobs;
    private long interviewInvitations;

    public CandidateDashboardResponse() {
    }

    public CandidateDashboardResponse(long availableJobs,
                                      long appliedJobs,
                                      long interviewInvitations) {
        this.availableJobs = availableJobs;
        this.appliedJobs = appliedJobs;
        this.interviewInvitations = interviewInvitations;
    }

    public long getAvailableJobs() {
        return availableJobs;
    }

    public void setAvailableJobs(long availableJobs) {
        this.availableJobs = availableJobs;
    }

    public long getAppliedJobs() {
        return appliedJobs;
    }

    public void setAppliedJobs(long appliedJobs) {
        this.appliedJobs = appliedJobs;
    }

    public long getInterviewInvitations() {
        return interviewInvitations;
    }

    public void setInterviewInvitations(long interviewInvitations) {
        this.interviewInvitations = interviewInvitations;
    }
}