package com.example.wanted.apply.repository;

import com.example.wanted.apply.domain.Apply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<Apply, Integer> {
}
