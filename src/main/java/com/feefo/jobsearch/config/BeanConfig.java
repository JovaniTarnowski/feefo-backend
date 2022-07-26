package com.feefo.jobsearch.config;

import liquibase.repackaged.org.apache.commons.text.similarity.JaroWinklerDistance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public JaroWinklerDistance jaroWinklerDistance() {
        return new JaroWinklerDistance();
    }
}
