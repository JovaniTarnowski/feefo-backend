package com.feefo.jobsearch.repository;

import com.feefo.jobsearch.model.Job;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobRepositoryTest {

    @Autowired
    private JobRepository jobRepository;

    @Test
    void getJobById(){
        Job job = new Job(1L,"Java Engineer");
        jobRepository.save(job);

        final var result = jobRepository.findById(job.getId());

        assertTrue(result.isPresent());
        result.ifPresent(r -> {
            assertEquals(job.getJobTitle(), r.getJobTitle());
            assertEquals(job.getId(), r.getId());
        });

    }

}