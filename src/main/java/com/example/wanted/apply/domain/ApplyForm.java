package com.example.wanted.apply.domain;

import lombok.Builder;
import lombok.Getter;

public class ApplyForm {

    @Getter
    public static class Request{

        private Integer jobNoticeId;

        private Integer memberId;
    }
}
