package com.example.wanted.job_notice.service;

import com.example.wanted.company.domain.Company;
import com.example.wanted.company.repository.CompanyRepository;
import com.example.wanted.exception.CustomException;
import com.example.wanted.job_notice.domain.*;
import com.example.wanted.job_notice.repository.JobNoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.wanted.exception.ErrorCode.*;

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

    @Transactional
    @Override
    public void removeJobNotice(Integer jobNoticeId) {

        JobNotice exstingJobNotice = jobNoticeRepository.findById(jobNoticeId)
                .orElseThrow(() -> new CustomException(JOB_NOTICE_NOT_FOUND));

        jobNoticeRepository.deleteById(jobNoticeId);
    }

    @Override
    public List<JobNoticeListDto.Response> findJobNotice() {

        List<JobNotice> jobNoticeList = jobNoticeRepository.findAll();

        ArrayList<JobNoticeListDto.Response> jobNoticeSearchDTOs = new ArrayList<>();

        for (JobNotice jobNotice : jobNoticeList) {
            Company company = companyRepository.findById(jobNotice.getCompanyId())
                    .orElseThrow(() -> new CustomException(COMPANY_NOT_FOUND));

            JobNoticeListDto.Response dtoResponse = JobNoticeListDto.Response.builder()
                    .jobNoticeId(jobNotice.getId())
                    .companyName(company.getName())
                    .nation(company.getNation())
                    .region(company.getRegion())
                    .position(jobNotice.getPosition())
                    .compensation(jobNotice.getCompensation())
                    .useTechnology(jobNotice.getUseTechnology())
                    .build();

            jobNoticeSearchDTOs.add(dtoResponse);
        }
        return jobNoticeSearchDTOs;
    }

    @Override
    public List<JobNoticeSearchDto.Response> searchJobNotice(String search) {
        List<JobNotice> jobNoticeList = jobNoticeRepository.findByUseTechnologyContaining(search);

        ArrayList<JobNoticeSearchDto.Response> jobNoticeSearchDTOs = new ArrayList<>();

        if (jobNoticeList.isEmpty()) {
            throw new CustomException(SEARCH_NOT_FOUND);
        }

        for (JobNotice jobNotice : jobNoticeList) {
            Company company = companyRepository.findById(jobNotice.getCompanyId())
                    .orElseThrow(() -> new CustomException(COMPANY_NOT_FOUND));
            JobNoticeSearchDto.Response dtoResponse = JobNoticeSearchDto.Response.builder()
                    .jobNoticeId(jobNotice.getId())
                    .companyName(company.getName())
                    .nation(company.getNation())
                    .region(company.getRegion())
                    .position(jobNotice.getPosition())
                    .compensation(jobNotice.getCompensation())
                    .useTechnology(jobNotice.getUseTechnology())
                    .build();
            jobNoticeSearchDTOs.add(dtoResponse);
        }
        return jobNoticeSearchDTOs;
    }

    @Override
    public JobNoticeDetailListDto.Response getDetailJobNotice(Integer jobNoticeId) {
        JobNotice jobNotice = jobNoticeRepository.findById(jobNoticeId).orElseThrow(
                () -> new CustomException(JOB_NOTICE_NOT_FOUND));
        Company company = companyRepository.findById(jobNotice.getCompanyId()).orElseThrow(
                () -> new CustomException(COMPANY_NOT_FOUND));

        JobNoticeDetailListDto.Response dtoResponse = JobNoticeDetailListDto.Response.builder()
                .jobNoticeId(jobNotice.getId())
                .companyName(company.getName())
                .nation(company.getNation())
                .region(company.getRegion())
                .position(jobNotice.getPosition())
                .compensation(jobNotice.getCompensation())
                .useTechnology(jobNotice.getUseTechnology())
                .details(jobNotice.getDetails())
                .build();

        return dtoResponse;
    }
}
