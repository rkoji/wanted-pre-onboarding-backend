package com.example.wanted.job_notice.controller;

import com.example.wanted.job_notice.domain.JobNoticeDto;
import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.domain.JobNoticeSearchDto;
import com.example.wanted.job_notice.domain.JobNoticeSearchForm;
import com.example.wanted.job_notice.service.JobNoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<JobNoticeForm.Response>> jobNoticeList() {
        List<JobNoticeDto.Response> jobNoticeDtoList = jobNoticeService.findJobNotice();
        List<JobNoticeForm.Response> jobNoticeFormList = jobNoticeDtoList.stream()
                .map(JobNoticeForm.Response::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(jobNoticeFormList);
    }

    @GetMapping(params = "search")
    public ResponseEntity<List<JobNoticeSearchForm.Response>> jobNoticeGetAll(
            @RequestParam String search) {
        List<JobNoticeSearchDto.Response> jobNoticeSearchDtoList = jobNoticeService.searchJobNotice(search);
        List<JobNoticeSearchForm.Response> jobNoticeSearchFormList = jobNoticeSearchDtoList.stream()
                .map(JobNoticeSearchForm.Response::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(jobNoticeSearchFormList);
    }

}
