package com.example.wanted.job_notice.domain;

import lombok.Builder;
import lombok.Getter;

public class JobNoticeForm {

    @Getter
    public static class Request {

        private Integer companyId;

        private String position;

        private Integer compensation;

        private String details;

        private String useTechnology;
    }

    @Getter
    @Builder
    public static class Response{

        private Integer jobNoticeId;

        private Integer companyId;

        private String position;

        private Integer compensation;

        private String details;

        private String useTechnology;

        public static JobNoticeForm.Response from(JobNoticeDto.Response response) {
            return Response.builder()
                    .jobNoticeId(response.getJobNoticeId())
                    .companyId(response.getCompanyId())
                    .position(response.getPosition())
                    .compensation(response.getCompensation())
                    .details(response.getDetails())
                    .useTechnology(response.getUseTechnology())
                    .build();
        }

    }
}
