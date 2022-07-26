package com.feefo.jobsearch.service;

import com.feefo.jobsearch.service.dto.JobScoreDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobServiceTest {

    JobScoreDTO jobScoreDTO = JobScoreDTO.builder()
                .qualityScore(1)
                .normalizedJobTitle("Software Engineer")
                .build();

    @Test
    void getNormalizedJobTitle() {

    }
}