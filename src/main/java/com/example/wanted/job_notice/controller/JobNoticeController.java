package com.example.wanted.job_notice.controller;

import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.service.JobNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor
@RequestMapping("/job-notice")
public class JobNoticeController {

    private final JobNoticeService jobNoticeService;

    @PostMapping
    public ResponseEntity<Void> jobNoticeAdd(@RequestBody JobNoticeForm.Request jobNoticeForm) {
        jobNoticeService.addJobNotice(jobNoticeForm);
        return ResponseEntity.status(CREATED).build();
    }

    @PutMapping("/{jobNoticeId}")
    public ResponseEntity<Void> jobNoticeModify(
            @PathVariable Integer jobNoticeId,
            @RequestBody JobNoticeForm.Request jobNoticeForm) {
        jobNoticeService.modifyJobNotice(jobNoticeId, jobNoticeForm);
        return ResponseEntity.status(OK).build();
    }

    @DeleteMapping("/{jobNoticeId}")
    public ResponseEntity<Void> jobNoticeRemove(@PathVariable Integer jobNoticeId) {
        jobNoticeService.removeJobNotice(jobNoticeId);
        return ResponseEntity.status(OK).build();
    }

}
