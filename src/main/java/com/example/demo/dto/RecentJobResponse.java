package com.example.demo.dto;

public class RecentJobResponse {

    private String jobTitle;
    private String companyName;
    private long applicationCount;

    public RecentJobResponse() {
    }

    public RecentJobResponse(String jobTitle, String companyName, long applicationCount) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.applicationCount = applicationCount;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public long getApplicationCount() {
        return applicationCount;
    }

    public void setApplicationCount(long applicationCount) {
        this.applicationCount = applicationCount;
    }

}