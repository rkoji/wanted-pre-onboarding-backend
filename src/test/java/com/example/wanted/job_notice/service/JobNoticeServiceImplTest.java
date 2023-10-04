//package com.example.wanted.job_notice.service;
//
//import com.example.wanted.job_notice.domain.JobNotice;
//import com.example.wanted.job_notice.domain.JobNoticeForm;
//import com.example.wanted.job_notice.repository.JobNoticeRepository;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//class JobNoticeServiceImplTest {
//
//    @Mock
//    private JobNoticeRepository jobNoticeRepository;
//
//    @InjectMocks
//    private JobNoticeServiceImpl jobNoticeServiceImpl;
//
//    @DisplayName("채용공고 등록 서비스 성공 테스트")
//    @Test
//    void addJobNoticeSuccess() {
//        // given
//        JobNoticeForm.Request formRequest = JobNoticeForm.Request.builder()
//                .companyId(1)
//                .position("백엔드 주니어 개발자")
//                .compensation(10000000)
//                .details("원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..")
//                .useTechnology("Python")
//                .build();
//
//        // when
//        jobNoticeServiceImpl.addJobNotice(formRequest);
//
//        // then
//        verify(jobNoticeRepository, times(1)).save(any(JobNotice.class));
//        verify(jobNoticeRepository).save(argThat(savedJobNotice -> {
//            return savedJobNotice.getCompanyId() == 1
//                    && "백엔드 주니어 개발자".equals(savedJobNotice.getPosition())
//                    && savedJobNotice.getCompensation() == 10000000
//                    && "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..".equals(savedJobNotice.getDetails())
//                    && "Python".equals(savedJobNotice.getUseTechnology());
//        }));
//    }
//}