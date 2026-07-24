package com.example.demo.ai;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchResponse {

    @JsonProperty("session_id")
    private String sessionId;

    @JsonProperty("candidate_name")
    private String candidateName;

    @JsonProperty("job_title")
    private String jobTitle;

    @JsonProperty("overall_match_score")
    private double overallMatchScore;

    private String recommendation;

    private String confidence;

    @JsonProperty("matched_skills_required")
    private List<String> matchedSkillsRequired;

    @JsonProperty("missing_skills_critical")
    private List<String> missingSkillsCritical;

    @JsonProperty("interview_questions_count")
    private int interviewQuestionsCount;

    private String summary;

    @JsonProperty("pipeline_status")
    private String pipelineStatus;

    private List<String> errors;

    public MatchResponse() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public double getOverallMatchScore() {
        return overallMatchScore;
    }

    public void setOverallMatchScore(double overallMatchScore) {
        this.overallMatchScore = overallMatchScore;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
        this.confidence = confidence;
    }

    public List<String> getMatchedSkillsRequired() {
        return matchedSkillsRequired;
    }

    public void setMatchedSkillsRequired(List<String> matchedSkillsRequired) {
        this.matchedSkillsRequired = matchedSkillsRequired;
    }

    public List<String> getMissingSkillsCritical() {
        return missingSkillsCritical;
    }

    public void setMissingSkillsCritical(List<String> missingSkillsCritical) {
        this.missingSkillsCritical = missingSkillsCritical;
    }

    public int getInterviewQuestionsCount() {
        return interviewQuestionsCount;
    }

    public void setInterviewQuestionsCount(int interviewQuestionsCount) {
        this.interviewQuestionsCount = interviewQuestionsCount;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPipelineStatus() {
        return pipelineStatus;
    }

    public void setPipelineStatus(String pipelineStatus) {
        this.pipelineStatus = pipelineStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}