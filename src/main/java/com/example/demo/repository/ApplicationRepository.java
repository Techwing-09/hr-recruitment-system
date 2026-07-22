package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByCandidate_Id(Long candidateId);

    List<Application> findByJob_Id(Long jobId);

    boolean existsByCandidate_IdAndJob_Id(Long candidateId, Long jobId);

    // Dashboard Counts
    long countByFinalStatus(String finalStatus);
    long countByCandidate_Id(Long candidateId);

    long countByCandidate_IdAndInterviewStatus(Long candidateId, String interviewStatus);

}