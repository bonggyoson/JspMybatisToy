package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQueryService {

    private final MemberMapper memberMapper;

    public int insertMember(InsertMemberDto insertMemberDto) {
        return memberMapper.insertMember(insertMemberDto);
    }

    public int updateMember(long memberId, UpdateMemberDto updateMemberDto) {
        return memberMapper.updateMember(updateMemberDto);
    }

    public int deleteMember(long memberId) {
        return memberMapper.deleteMember(memberId);
    }
}
