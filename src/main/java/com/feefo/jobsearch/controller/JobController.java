package com.feefo.jobsearch.controller;

import com.feefo.jobsearch.service.JobService;
import com.feefo.jobsearch.service.dto.JobScoreDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/job")
public class JobController {

    private final JobService service;

    @GetMapping("/get-normalized-job-title")
    public final ResponseEntity<JobScoreDTO> getNormalizedJobTitle(@RequestParam String jobTitle){

        return new ResponseEntity<>(service.getNormalizedJobTitle(jobTitle), HttpStatus.OK);
    }
}
