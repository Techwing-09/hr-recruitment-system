package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.DashboardResponse;
import com.example.demo.dto.RecentJobResponse;
import com.example.demo.models.Job;
import com.example.demo.repository.ApplicationRepository;
import com.example.demo.repository.CandidateRepository;
import com.example.demo.repository.JobRepository;

@Service
public class DashboardService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    public DashboardResponse getDashboardData() {

        long totalJobs = jobRepository.count();

        long totalCandidates = candidateRepository.count();

        long selectedCandidates =
                applicationRepository.countByFinalStatus("OFFERED");

        long rejectedCandidates =
                applicationRepository.countByFinalStatus("REJECTED");

        List<Job> jobs = jobRepository.findAll();

        List<RecentJobResponse> recentJobs = new ArrayList<>();

        for (Job job : jobs) {

            long applicationCount =
                    applicationRepository.findByJob_Id(job.getId()).size();

            recentJobs.add(
                    new RecentJobResponse(
                            job.getJobTitle(),
                            job.getCompanyName(),
                            applicationCount
                    )
            );

        }

        return new DashboardResponse(
                totalJobs,
                totalCandidates,
                selectedCandidates,
                rejectedCandidates,
                recentJobs
        );

    }

}