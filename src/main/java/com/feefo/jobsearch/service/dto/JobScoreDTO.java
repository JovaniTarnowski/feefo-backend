package com.feefo.jobsearch.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder(toBuilder = true)
public class JobScoreDTO {

    private String normalizedJobTitle;

    private double qualityScore;

}
