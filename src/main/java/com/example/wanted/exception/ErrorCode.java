package com.example.wanted.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    JOB_NOTICE_NOT_FOUND(NOT_FOUND, "채용공고를 찾을 수 없습니다."),

    DUPLICATE_RESOURCE(CONFLICT, "데이터가 이미 존재합니다.")
    ;

    private final HttpStatus httpStatus;
    private final String detail;

}
