package com.example.JspMybatisSample.mapper.mypage;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    MemberDto selectMyPageMember(long memberId);
}
