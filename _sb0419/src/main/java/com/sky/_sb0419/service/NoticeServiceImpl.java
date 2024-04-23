package com.sky._sb0419.service;

import com.sky._sb0419.Entity.Notice;
import com.sky._sb0419.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{
    private final NoticeRepository noticeRepository;

    @Override // 매개변수 받은거를 그대로 돌려준다.
    public Notice saveNotice(Notice notice){
        noticeRepository.insertNotice(notice);
        return notice;
    }
}
