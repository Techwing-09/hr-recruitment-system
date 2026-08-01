package com.example.demo.controller;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.models.Resume;
import com.example.demo.service.ResumeService;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin(origins = "*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    // Upload Resume
    @PostMapping("/upload/{candidateId}")
    public ResponseEntity<Resume> uploadResume(
            @PathVariable Long candidateId,
            @RequestParam("file") MultipartFile file) throws IOException {

        Resume resume = resumeService.uploadResume(candidateId, file);
        return ResponseEntity.ok(resume);
    }

    // View Resume
    @GetMapping("/view/{candidateId}")
    public ResponseEntity<Resource> viewResume(
            @PathVariable Long candidateId) throws IOException {

        Resource resource = resumeService.viewResume(candidateId);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    // Delete Resume
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteResume(
            @PathVariable Long id) {

        resumeService.deleteResume(id);

        return ResponseEntity.ok("Resume deleted successfully.");
    }
}