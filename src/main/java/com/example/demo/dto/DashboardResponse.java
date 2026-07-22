package com.example.demo.dto;

import java.util.List;

public class DashboardResponse {

    private long totalJobs;
    private long totalCandidates;
    private long selectedCandidates;
    private long rejectedCandidates;

    private List<RecentJobResponse> recentJobs;

    public DashboardResponse() {
    }

    public DashboardResponse(long totalJobs,
                             long totalCandidates,
                             long selectedCandidates,
                             long rejectedCandidates,
                             List<RecentJobResponse> recentJobs) {

        this.totalJobs = totalJobs;
        this.totalCandidates = totalCandidates;
        this.selectedCandidates = selectedCandidates;
        this.rejectedCandidates = rejectedCandidates;
        this.recentJobs = recentJobs;
    }

    public long getTotalJobs() {
        return totalJobs;
    }

    public void setTotalJobs(long totalJobs) {
        this.totalJobs = totalJobs;
    }

    public long getTotalCandidates() {
        return totalCandidates;
    }

    public void setTotalCandidates(long totalCandidates) {
        this.totalCandidates = totalCandidates;
    }

    public long getSelectedCandidates() {
        return selectedCandidates;
    }

    public void setSelectedCandidates(long selectedCandidates) {
        this.selectedCandidates = selectedCandidates;
    }

    public long getRejectedCandidates() {
        return rejectedCandidates;
    }

    public void setRejectedCandidates(long rejectedCandidates) {
        this.rejectedCandidates = rejectedCandidates;
    }

    public List<RecentJobResponse> getRecentJobs() {
        return recentJobs;
    }

    public void setRecentJobs(List<RecentJobResponse> recentJobs) {
        this.recentJobs = recentJobs;
    }

}