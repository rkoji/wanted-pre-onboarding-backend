package com.example.wanted.job_notice.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

public class JobNoticeDetailListForm {

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

        public static JobNoticeDetailListForm.Response from(JobNoticeDetailListDto.Response response) {
            return Response.builder()
                    .jobNoticeId(response.getJobNoticeId())
                    .companyName(response.getCompanyName())
                    .nation(response.getNation())
                    .region(response.getRegion())
                    .position(response.getPosition())
                    .compensation(response.getCompensation())
                    .useTechnology(response.getUseTechnology())
                    .details(response.getDetails())
                    .otherJobNoticesId(response.getOtherJobNoticesId())
                    .build();
        }

    }
}
