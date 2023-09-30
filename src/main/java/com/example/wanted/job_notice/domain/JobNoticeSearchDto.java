package com.example.wanted.job_notice.domain;

import lombok.Getter;

public class JobNoticeSearchDto {

    @Getter
    public static class Response {

        private Integer jobNoticeId;

        private String companyName;

        private String nation;

        private String region;

        private String position;

        private Integer compensation;

        private String useTechnology;

    }
}
