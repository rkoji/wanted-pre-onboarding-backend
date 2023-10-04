package com.example.wanted.job_notice.service;

import com.example.wanted.job_notice.domain.dto.JobNoticeDetailListDto;
import com.example.wanted.job_notice.domain.dto.JobNoticeListDto;
import com.example.wanted.job_notice.domain.dto.JobNoticeSearchDto;
import com.example.wanted.job_notice.domain.form.JobNoticeForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobNoticeService {
    void addJobNotice(JobNoticeForm.Request jobNoticeForm);

    void modifyJobNotice(Integer jobNoticeId, JobNoticeForm.Request jobNoticeForm);

    void removeJobNotice(Integer jobNoticeId);

    List<JobNoticeListDto.Response> findJobNotice();

    List<JobNoticeSearchDto.Response> searchJobNotice(String search);

    JobNoticeDetailListDto.Response getDetailJobNotice(Integer jobNoticeId);
}
