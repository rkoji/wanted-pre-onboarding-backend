package com.example.wanted.apply.service;

import com.example.wanted.apply.domain.entity.Apply;
import com.example.wanted.apply.domain.form.ApplyForm;
import com.example.wanted.apply.repository.ApplyRepository;
import com.example.wanted.exception.CustomException;
import com.example.wanted.job_notice.domain.entity.JobNotice;
import com.example.wanted.job_notice.repository.JobNoticeRepository;
import com.example.wanted.member.domain.Member;
import com.example.wanted.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.example.wanted.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
public class ApplyServiceImpl implements ApplyService {

    private final MemberRepository memberRepository;
    private final JobNoticeRepository jobNoticeRepository;
    private final ApplyRepository applyRepository;

    @Override
    public void applyJobNotice(ApplyForm.Request applyForm) {
        memberRepository.findById(applyForm.getMemberId())
                .orElseThrow(() -> new CustomException(MEMBER_NOT_FOUND));

        jobNoticeRepository.findById(applyForm.getJobNoticeId())
                .orElseThrow(() -> new CustomException(JOB_NOTICE_NOT_FOUND));

        boolean isAlreadyApplied =
                applyRepository.existsByJobNoticeIdAndMemberId(applyForm.getJobNoticeId(), applyForm.getMemberId());

        if (isAlreadyApplied) {
            throw new CustomException(APPLY_ONLY_ONCE);
        }

        applyRepository.save(Apply.builder()
                .jobNoticeId(applyForm.getJobNoticeId())
                .memberId(applyForm.getMemberId())
                .build());

    }
}
