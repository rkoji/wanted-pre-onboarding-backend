package com.example.wanted.job_notice.service;

import com.example.wanted.job_notice.domain.JobNoticeDto;
import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.domain.JobNoticeListDto;
import com.example.wanted.job_notice.domain.JobNoticeSearchDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JobNoticeService {
    void addJobNotice(JobNoticeForm.Request jobNoticeForm);

    void modifyJobNotice(Integer jobNoticeId, JobNoticeForm.Request jobNoticeForm);

    void removeJobNotice(Integer jobNoticeId);

    List<JobNoticeListDto.Response> findJobNotice();

    List<JobNoticeSearchDto.Response> searchJobNotice(String search);

//    void getDetailJobNotice(Integer jobNoticeId);
}
