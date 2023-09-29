package com.example.wanted.job_notice.service;

import com.example.wanted.company.repository.CompanyRepository;
import com.example.wanted.exception.CustomException;
import com.example.wanted.job_notice.domain.JobNotice;
import com.example.wanted.job_notice.domain.JobNoticeDto;
import com.example.wanted.job_notice.domain.JobNoticeForm;
import com.example.wanted.job_notice.repository.JobNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.example.wanted.exception.ErrorCode.COMPANY_NOT_FOUND;
import static com.example.wanted.exception.ErrorCode.JOB_NOTICE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class JobNoticeServiceImpl implements JobNoticeService {

    private final JobNoticeRepository jobNoticeRepository;
    private final CompanyRepository companyRepository;

    @Transactional
    @Override
    public void addJobNotice(JobNoticeForm.Request jobNoticeForm) {

        companyRepository.findById(jobNoticeForm.getCompanyId())
                .orElseThrow(() -> new CustomException(COMPANY_NOT_FOUND));

        JobNoticeDto.Request dtoRequest = JobNoticeDto.Request.from(jobNoticeForm);

        jobNoticeRepository.save(JobNotice.builder()
                .companyId(dtoRequest.getCompanyId())
                .position(dtoRequest.getPosition())
                .compensation(dtoRequest.getCompensation())
                .details(dtoRequest.getDetails())
                .useTechnology(dtoRequest.getUseTechnology())
                .build());
    }

    @Transactional
    @Override
    public void modifyJobNotice(Integer jobNoticeId, JobNoticeForm.Request jobNoticeForm) {

        JobNotice exstingJobNotice = jobNoticeRepository.findById(jobNoticeId).orElseThrow(
                () -> new CustomException(JOB_NOTICE_NOT_FOUND));

        JobNoticeDto.Request dtoRequest = JobNoticeDto.Request.from(jobNoticeForm);

        exstingJobNotice.modifyJobNotice(dtoRequest);
        jobNoticeRepository.save(exstingJobNotice);

    }

}
