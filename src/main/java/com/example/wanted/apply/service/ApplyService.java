package com.example.wanted.apply.service;

import com.example.wanted.apply.domain.form.ApplyForm;
import org.springframework.stereotype.Service;

@Service
public interface ApplyService {

    void applyJobNotice(ApplyForm.Request applyForm);
}
