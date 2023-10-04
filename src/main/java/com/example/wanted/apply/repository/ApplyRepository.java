package com.example.wanted.apply.repository;

import com.example.wanted.apply.domain.entity.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {
    boolean existsByJobNoticeIdAndMemberId(Integer jobNoticeId, Integer memberId);
}
