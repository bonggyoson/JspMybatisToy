package com.example.JspMybatisSample.mapper.member;

import com.example.JspMybatisSample.domain.member.Member;
import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.github.pagehelper.Page;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    Page<MemberWithoutPasswordDto> selectMembers();

    MemberWithPasswordDto selectMember(String memberEmail);

    MemberWithPasswordDto selectMember(long memberId);

    int checkDuplicateEmail(String memberEmail);

    int insertMember(InsertMemberDto insertMemberDto);

    int updateMember(@Param("memberId") long memberId,
        @Param("member") UpdateMemberDto updateMemberDto);

    int deleteMember(long memberId);

    int updateMemberPassword(long memberId, String memberPassword);
}
