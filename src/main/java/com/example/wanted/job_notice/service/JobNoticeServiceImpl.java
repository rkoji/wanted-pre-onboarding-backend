package com.example.wanted.job_notice.service;

import com.example.wanted.job_notice.domain.JobNotice;
import com.example.wanted.job_notice.domain.JobNoticeDto;
import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.repository.JobNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobNoticeServiceImpl implements JobNoticeService {

    private final JobNoticeRepository jobNoticeRepository;

    @Override
    public void addJobNotice(JobNoticeForm.Request jobNoticeForm) {
        JobNoticeDto.Request dtoRequest = JobNoticeDto.Request.from(jobNoticeForm);
        jobNoticeRepository.save(JobNotice.builder()
                .companyId(dtoRequest.getCompanyId())
                .position(dtoRequest.getPosition())
                .compensation(dtoRequest.getCompensation())
                .details(dtoRequest.getDetails())
                .useTechnology(dtoRequest.getUseTechnology())
                .build());
    }
}
