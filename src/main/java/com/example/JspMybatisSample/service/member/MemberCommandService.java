package com.example.JspMybatisSample.service.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
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

    public Page<MemberWithoutPasswordDto> selectMembers(int pageNum) {
        PageHelper.startPage(pageNum, 10);

        return memberMapper.selectMembers();
    }

    public MemberWithPasswordDto selectMember(long memberId) {
        return memberMapper.selectMember(memberId);
    }

    public int checkDuplicateEmail(String memberEmail) {
        return memberMapper.checkDuplicateEmail(memberEmail);
    }
}
