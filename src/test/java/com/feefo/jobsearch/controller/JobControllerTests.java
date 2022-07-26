package com.feefo.jobsearch.controller;

import com.feefo.jobsearch.model.Job;
import com.feefo.jobsearch.repository.JobRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class JobControllerTests {

    private static final MediaType JSON_UTF8 = new MediaType("application", "json", UTF_8);

    private static final String URL = "/v1/job/get-normalized-job-title/";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    JobRepository jobRepository;

    @BeforeEach
    void algumaCoisa(){
        jobRepository.save(new Job(1L,"Software Engineer"));
        jobRepository.save(new Job(2L,"Accountant"));
    }

    @Test
    @Transactional
    @DisplayName("Get normalized Job Title with Sucess")
    void getNormalizedJobTitleSucessAccountant() throws Exception{

        ResultActions resultActions = mockMvc.perform(get(URL).contentType(JSON_UTF8)
            .queryParam("jobTitle", "Accountant"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @DisplayName("Get normalized Job Title with Sucess")
    void getNormalizedJobTitleSucessArchitect() throws Exception{

        ResultActions resultActions = mockMvc.perform(get(URL).contentType(JSON_UTF8)
                        .queryParam("jobTitle", "Architect"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    @Transactional
    @DisplayName("Get normalized Job Title with Sucess")
    void getNormalizedJobTitleSucessSoftwareEngineer() throws Exception{

        ResultActions resultActions = mockMvc.perform(get(URL).contentType(JSON_UTF8)
                        .queryParam("jobTitle", "Software engineer"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    @Transactional
    @DisplayName("Get normalized Job Title with Sucess")
    void getNormalizedJobTitleSucessQuantitySurveyor() throws Exception{

        ResultActions resultActions = mockMvc.perform(get(URL).contentType(JSON_UTF8)
                        .queryParam("jobTitle", "Quantity surveyor"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


}
