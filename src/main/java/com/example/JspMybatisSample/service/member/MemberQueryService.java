package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        return memberMapper.updateMember(memberId, updateMemberDto);
    }

    public int deleteMember(long memberId) {
        return memberMapper.deleteMember(memberId);
    }

    // 임시 비밀번호 생성
    public String createNewPassword() {
        return RandomStringUtils.randomAlphanumeric(8);
    }

    // 비밀번호 변경
    public int updateMemberPassword(long memberId, String memberPassword) {
        return memberMapper.updateMemberPassword(memberId,
            new BCryptPasswordEncoder().encode(memberPassword));
    }
}
