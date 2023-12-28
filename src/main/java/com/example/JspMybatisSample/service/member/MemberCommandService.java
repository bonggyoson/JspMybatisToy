package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandService {

    private final MemberMapper memberMapper;

    public Page<MemberDto> selectMembers(int pageNum) {
        PageHelper.startPage(pageNum, 10);

        return memberMapper.selectMembers();
    }

    public MemberDto selectMember(long memberId) {
        return memberMapper.selectMember(memberId);
    }

    public int checkDuplicateEmail(String memberEmail) {
        return memberMapper.checkDuplicateEmail(memberEmail);
    }
}
