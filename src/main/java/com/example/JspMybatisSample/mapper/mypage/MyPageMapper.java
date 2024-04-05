package com.example.JspMybatisSample.mapper.mypage;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MyPageMapper {

    MemberDto selectMyPageMember(long memberId);

    Page<ArticleDto> selectMyPageArticle(long memberId);
}
