package com.example.wanted.job_notice.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class JobNoticeDetailListDto {

    @Getter
    @Builder
    public static class Response {

        private Integer jobNoticeId;

        private String companyName;

        private String nation;

        private String region;

        private String position;

        private Integer compensation;

        private String useTechnology;

        private String details;

        private List<Integer> otherJobNoticesId;

    }
}
