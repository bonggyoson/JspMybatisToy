package com.example.JspMybatisSample.mapper.mypage;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    MemberWithPasswordDto selectMyPageMember(long memberId);

    Page<ArticleDto> selectMyPageArticle(long memberId);
}
