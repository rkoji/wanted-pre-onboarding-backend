package com.example.wanted.job_notice.controller;

import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.service.JobNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequiredArgsConstructor
public class JobNoticeController {

    private final JobNoticeService jobNoticeService;

    @PostMapping
    public ResponseEntity<?> jobNoticeAdd(@RequestBody JobNoticeForm.Request jobNoticeForm) {
        jobNoticeService.addJobNotice(jobNoticeForm);
        return ResponseEntity.status(CREATED).build();
    }
}
