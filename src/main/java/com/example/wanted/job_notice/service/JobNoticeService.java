package com.example.wanted.job_notice.service;

import com.example.wanted.job_notice.domain.JobNoticeForm;
import org.springframework.stereotype.Service;

@Service
public interface JobNoticeService {
    void addJobNotice(JobNoticeForm.Request jobNoticeForm);
}