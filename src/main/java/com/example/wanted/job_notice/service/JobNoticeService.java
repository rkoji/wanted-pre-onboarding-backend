package com.example.wanted.job_notice.service;

import com.example.wanted.job_notice.domain.JobNoticeDto;
import com.example.wanted.job_notice.domain.JobNoticeForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobNoticeService {
    void addJobNotice(JobNoticeForm.Request jobNoticeForm);

    void modifyJobNotice(Integer jobNoticeId, JobNoticeForm.Request jobNoticeForm);

    void removeJobNotice(Integer jobNoticeId);

    List<JobNoticeDto.Response> findJobNotice();
}
