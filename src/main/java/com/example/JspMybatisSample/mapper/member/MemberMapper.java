package com.example.JspMybatisSample.mapper.member;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.UpdateMemberDto;
import com.github.pagehelper.Page;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    Page<MemberDto> selectMembers();

    MemberDto selectMember(String memberEmail);

    MemberDto selectMember(long memberId);

    int insertMember(InsertMemberDto insertMemberDto);

    int updateMember(UpdateMemberDto updateMemberDto);

}
