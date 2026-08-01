package com.example.demo.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exception.ResumeNotFoundException;
import com.example.demo.models.Resume;
import com.example.demo.repository.ResumeRepository;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    // Upload Resume
    public Resume uploadResume(Long candidateId, MultipartFile file) throws IOException {

        File directory = new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName = candidateId + "_" + file.getOriginalFilename();

        Path filePath = Paths.get(uploadDir, fileName);

        Files.copy(file.getInputStream(), filePath);

        Optional<Resume> existingResume =
                resumeRepository.findByCandidateId(candidateId);

        Resume resume;

        if (existingResume.isPresent()) {
        	resume = existingResume.get();
        	File oldFile = new File(resume.getFilePath());

        	if (oldFile.exists()) {
        	    boolean deleted = oldFile.delete();

        	    if (!deleted) {
        	        System.out.println("Failed to delete old resume: " + oldFile.getAbsolutePath());
        	    }
        	}

        } else {

            resume = new Resume();
            resume.setCandidateId(candidateId);
            resume.setCreatedAt(LocalDateTime.now());

        }

        resume.setFileName(fileName);
        resume.setFilePath(filePath.toString());
        resume.setUpdatedAt(LocalDateTime.now());

        return resumeRepository.save(resume);
    }

    // View Resume
    public Resource viewResume(Long candidateId) throws IOException {

        Resume resume = resumeRepository
                .findByCandidateId(candidateId)
                .orElseThrow(() ->
                        new ResumeNotFoundException("Resume not found"));

        Path path = Paths.get(resume.getFilePath());

        Resource resource = new UrlResource(path.toUri());

        if (!resource.exists()) {
            throw new ResumeNotFoundException("Resume file not found");
        }

        return resource;
    }

    // Delete Resume
    public void deleteResume(Long id) {

        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() ->
                        new ResumeNotFoundException("Resume not found"));

        File file = new File(resume.getFilePath());

        if (file.exists()) {

            boolean deleted = file.delete();

            if (!deleted) {
                System.out.println("Failed to delete resume file: " + file.getAbsolutePath());
            }
        }

        resumeRepository.delete(resume);
    }

}