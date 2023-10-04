package com.example.wanted.apply.domain.form;

import lombok.Getter;

public class ApplyForm {

    @Getter
    public static class Request {

        private Integer jobNoticeId;

        private Integer memberId;
    }
}
