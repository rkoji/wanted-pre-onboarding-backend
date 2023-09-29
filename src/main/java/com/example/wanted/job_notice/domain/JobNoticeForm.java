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
}
