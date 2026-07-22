package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.CandidateDashboardResponse;
import com.example.demo.service.CandidateDashboardService;

@RestController
@RequestMapping("/api/candidate-dashboard")
@CrossOrigin(origins = "http://localhost:4200")
public class CandidateDashboardController {

    @Autowired
    private CandidateDashboardService dashboardService;

    @GetMapping("/{candidateId}")
    public CandidateDashboardResponse getDashboard(
            @PathVariable Long candidateId) {

        return dashboardService.getDashboard(candidateId);
    }
}