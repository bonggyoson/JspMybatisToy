package com.example.JspMybatisSample.mapper.member;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    MemberDto selectMember(String memberEmail);

}
