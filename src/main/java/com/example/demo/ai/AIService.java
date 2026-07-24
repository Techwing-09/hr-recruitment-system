package com.example.demo.ai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Application;
import com.example.demo.models.Job;
import com.example.demo.models.Resume;

@Service
public class AIService {

    @Autowired
    private AIClient aiClient;

    /**
     * Calls Python GenAI Match API and updates Application entity
     */
    public void generateMatchScore(Application application,
                                   Resume resume,
                                   Job job) {

        try {

            System.out.println("========== REQUEST TO GENAI ==========");
            System.out.println("Resume Path      : " + resume.getFilePath());
            System.out.println("Company Name     : " + job.getCompanyName());
            System.out.println("Job Description  : " + job.getJobDescription());
            System.out.println("Description Size : " + job.getJobDescription().length());
            System.out.println("======================================");

            MatchResponse response = aiClient.getMatchScore(
                    resume.getFilePath(),
                    job.getJobDescription(),
                    job.getCompanyName(),
                    "HR Manager"
            );

            if (response == null) {
                throw new RuntimeException("No response received from GenAI service.");
            }

            System.out.println("========== GENAI RESPONSE ==========");
            System.out.println("Session ID               : " + response.getSessionId());
            System.out.println("Candidate Name           : " + response.getCandidateName());
            System.out.println("Job Title                : " + response.getJobTitle());
            System.out.println("Overall Match Score      : " + response.getOverallMatchScore());
            System.out.println("Recommendation           : " + response.getRecommendation());
            System.out.println("Confidence               : " + response.getConfidence());
            System.out.println("Matched Skills           : " + response.getMatchedSkillsRequired());
            System.out.println("Missing Skills           : " + response.getMissingSkillsCritical());
            System.out.println("Interview Questions      : " + response.getInterviewQuestionsCount());
            System.out.println("Summary                  : " + response.getSummary());
            System.out.println("Pipeline Status          : " + response.getPipelineStatus());
            System.out.println("Errors                   : " + response.getErrors());
            System.out.println("====================================");

            application.setMatchScore(response.getOverallMatchScore());
            application.setAiFeedback(response.getSummary());

            application.setInterviewStatus("Questions Generated");
            application.setFinalStatus("Interview Pending");

        } catch (Exception e) {

            System.out.println("========== GENAI ERROR ==========");
            e.printStackTrace();
            System.out.println("=================================");

            application.setMatchScore(0.0);
            application.setAiFeedback("Unable to generate AI Match Score.");
            application.setInterviewStatus("AI Failed");
            application.setFinalStatus("Pending");
        }
    }
}