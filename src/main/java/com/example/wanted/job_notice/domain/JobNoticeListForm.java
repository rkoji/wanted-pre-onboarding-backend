package com.example.wanted.job_notice.domain;

import lombok.Builder;
import lombok.Getter;

public class JobNoticeListForm {

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

        public static JobNoticeListForm.Response from(JobNoticeListDto.Response response) {
            return JobNoticeListForm.Response.builder()
                    .jobNoticeId(response.getJobNoticeId())
                    .companyName(response.getCompanyName())
                    .nation(response.getNation())
                    .region(response.getRegion())
                    .position(response.getPosition())
                    .compensation(response.getCompensation())
                    .useTechnology(response.getUseTechnology())
                    .build();
        }
    }
}
