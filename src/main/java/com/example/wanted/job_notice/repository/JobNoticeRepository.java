package com.example.wanted.job_notice.repository;

import com.example.wanted.job_notice.domain.JobNotice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobNoticeRepository extends JpaRepository<JobNotice, Integer> {
}
