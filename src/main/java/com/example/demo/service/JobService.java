package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.JobRequest;
import com.example.demo.dto.JobResponse;
import com.example.demo.exception.JobNotFoundException;
import com.example.demo.models.Job;
import com.example.demo.repository.JobRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Create Job
    public JobResponse createJob(JobRequest request) {

        Job job = new Job();

        job.setJobTitle(request.getJobTitle());
        job.setCompanyName(request.getCompanyName());
        job.setRequiredSkills(request.getRequiredSkills());
        job.setExperience(request.getExperience());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setJobDescription(request.getJobDescription());

        Job savedJob = jobRepository.save(job);

        return mapToResponse(savedJob, "Job created successfully.");
    }

    // Get All Jobs
    public List<JobResponse> getAllJobs() {

        List<Job> jobs = jobRepository.findAll();
        List<JobResponse> responses = new ArrayList<>();

        for (Job job : jobs) {
            responses.add(mapToResponse(job, null));
        }

        return responses;
    }

    // Get Job By Id
    public JobResponse getJobById(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException("Job not found with id : " + id));

        return mapToResponse(job, null);
    }

    // Update Job
    public JobResponse updateJob(Long id, JobRequest request) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException("Job not found with id : " + id));

        job.setJobTitle(request.getJobTitle());
        job.setCompanyName(request.getCompanyName());
        job.setRequiredSkills(request.getRequiredSkills());
        job.setExperience(request.getExperience());
        job.setSalary(request.getSalary());
        job.setLocation(request.getLocation());
        job.setJobDescription(request.getJobDescription());

        Job updatedJob = jobRepository.save(job);

        return mapToResponse(updatedJob, "Job updated successfully.");
    }

    // Delete Job
    public void deleteJob(Long id) {

        Job job = jobRepository.findById(id)
                .orElseThrow(() ->
                        new JobNotFoundException("Job not found with id : " + id));

        jobRepository.delete(job);
    }

    // Convert Entity to DTO
    private JobResponse mapToResponse(Job job, String message) {

        JobResponse response = new JobResponse();

        response.setId(job.getId());
        response.setJobTitle(job.getJobTitle());
        response.setCompanyName(job.getCompanyName());
        response.setRequiredSkills(job.getRequiredSkills());
        response.setExperience(job.getExperience());
        response.setSalary(job.getSalary());
        response.setLocation(job.getLocation());
        response.setJobDescription(job.getJobDescription());
        response.setMessage(message);

        return response;
    }
}