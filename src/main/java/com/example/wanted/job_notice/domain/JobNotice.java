package com.example.wanted.job_notice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobNotice {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer companyId;

    private String position;

    private Integer compensation;

    private String details;

    private String useTechnology;

    public void  modifyJobNotice(JobNoticeDto.Request request) {
        this.position = request.getPosition();
        this.compensation = request.getCompensation();
        this.details = request.getDetails();
        this.useTechnology = request.getUseTechnology();
    }


}
