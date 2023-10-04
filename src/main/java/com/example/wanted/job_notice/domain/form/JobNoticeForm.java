package com.example.wanted.job_notice.domain.form;

import com.example.wanted.job_notice.domain.dto.JobNoticeDto;
import com.example.wanted.job_notice.domain.dto.JobNoticeListDto;
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

    public static class JobNoticeListForm {

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

            public static Response from(JobNoticeListDto.Response response) {
                return Response.builder()
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
}
