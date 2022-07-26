package com.feefo.jobsearch.service;

import com.feefo.jobsearch.model.Job;
import com.feefo.jobsearch.repository.JobRepository;
import com.feefo.jobsearch.service.dto.JobScoreDTO;
import liquibase.repackaged.org.apache.commons.text.similarity.JaroWinklerDistance;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private static final JobScoreDTO QUALITY_SCORE_DTO = JobScoreDTO.builder()
            .normalizedJobTitle("")
            .build();

    private final JaroWinklerDistance matcher;

    private final JobRepository repository;


    public JobScoreDTO getNormalizedJobTitle(String jobTitle){
        List<JobScoreDTO> qualityScoreList = repository.findAll()
                .stream()
                .map(title -> getScoredTitleDTO(jobTitle, title.getJobTitle()))
                .collect(Collectors.toList());
        return qualityScoreList.stream()
                .reduce(QUALITY_SCORE_DTO, this::compareScoredTitleDTO);
    }

    private JobScoreDTO getScoredTitleDTO(String jobTitle, String normalizedTitle) {
        Double qualityScoreNormalized = matcher.apply(jobTitle, normalizedTitle);
        return JobScoreDTO.builder()
                .qualityScore(qualityScoreNormalized)
                .normalizedJobTitle(normalizedTitle)
                .build();
    }

    private JobScoreDTO compareScoredTitleDTO(JobScoreDTO bestMatch, JobScoreDTO next) {

        return bestMatch.getQualityScore() > next.getQualityScore()
                ? bestMatch
                : next;
    }

}
