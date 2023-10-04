package com.example.wanted.apply.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Apply {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer jobNoticeId;

    private Integer memberId;
}
