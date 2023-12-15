package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {

    private final MemberMapper memberMapper;

    public int insertMember(InsertMemberDto insertMemberDto) {
        return memberMapper.insertMember(insertMemberDto);
    }
}
