package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CandidateDashboardResponse;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.JobRepository;

@Service
public class CandidateDashboardService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public CandidateDashboardResponse getDashboard(Long candidateId) {

        long availableJobs = jobRepository.count();

        long appliedJobs =
                applicationRepository.countByCandidate_Id(candidateId);

        long interviewInvitations =
                applicationRepository.countByCandidate_IdAndInterviewStatus(
                        candidateId,
                        "SCHEDULED"
                );

        return new CandidateDashboardResponse(
                availableJobs,
                appliedJobs,
                interviewInvitations
        );
    }
}