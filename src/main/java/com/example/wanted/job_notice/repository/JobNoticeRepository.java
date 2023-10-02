package com.example.wanted.job_notice.repository;

import com.example.wanted.job_notice.domain.JobNotice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Integer> {

    List<JobNotice> findByUseTechnologyContaining(String search);

    List<JobNotice> findByCompanyId(Integer companyId);
}
