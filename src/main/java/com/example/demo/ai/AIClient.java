package com.example.demo.ai;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class AIClient {

    private final RestTemplate restTemplate;

    public AIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String MATCH_API =
            "http://localhost:8000/api/v1/match";

    public MatchResponse getMatchScore(
            String resumePath,
            String jobDescription,
            String companyName,
            String hiringManager) {

        File file = new File(resumePath);

        if (!file.exists()) {
            throw new RuntimeException("Resume file not found : " + resumePath);
        }

        FileSystemResource resource = new FileSystemResource(file);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

        body.add("resume", resource);
        body.add("jd_text", jobDescription);
        body.add("company_name", companyName);
        body.add("hiring_manager", hiringManager);

        HttpEntity<MultiValueMap<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<MatchResponse> response =
                restTemplate.postForEntity(
                        MATCH_API,
                        request,
                        MatchResponse.class);

        return response.getBody();
    }

}