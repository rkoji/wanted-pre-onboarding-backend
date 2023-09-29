package com.example.wanted.job_notice.domain;

import lombok.Builder;
import lombok.Getter;

public class JobNoticeDto {

    @Getter
    @Builder
    public static class Request {

        private Integer companyId;

        private String position;

        private Integer compensation;

        private String details;

        private String useTechnology;

        public static JobNoticeDto.Request from(JobNoticeForm.Request jobNoticeForm) {
            return Request.builder()
                    .companyId(jobNoticeForm.getCompanyId())
                    .position(jobNoticeForm.getPosition())
                    .compensation(jobNoticeForm.getCompensation())
                    .details(jobNoticeForm.getDetails())
                    .useTechnology(jobNoticeForm.getUseTechnology())
                    .build();
        }
    }
}
