package com.example.JspMybatisSample.service.mypage;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.mapper.mypage.MyPageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MyPageCommandService {

    private final MyPageMapper myPageMapper;

    public MemberDto selectMyPageMember(long memberId) {
        return myPageMapper.selectMyPageMember(memberId);
    }
}
