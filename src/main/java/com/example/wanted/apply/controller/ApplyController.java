package com.example.wanted.apply.controller;

import com.example.wanted.apply.domain.form.ApplyForm;
import com.example.wanted.apply.service.ApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.HttpStatus.CREATED;

@Controller
@RequiredArgsConstructor
@RequestMapping("/apply")
public class ApplyController {

    private final ApplyService applyService;

    @PostMapping
    public ResponseEntity<Void> JobNoticeApply(
            @RequestBody ApplyForm.Request applyForm) {
        applyService.applyJobNotice(applyForm);
        return ResponseEntity.status(CREATED).build();
    }
}
