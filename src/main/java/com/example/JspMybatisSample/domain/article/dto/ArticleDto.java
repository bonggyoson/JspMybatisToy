package com.example.JspMybatisSample.domain.article.dto;

import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto extends BaseEntity {

    /* 번호 (PK) */
    private Long articleId;

    /* 회원 (FK) */
    private MemberDto member;

    /* 제목 */
    private String articleTitle;

    /* 내용 */
    private String articleContent;

    /* 조회수 */
    private int articleViewCount;

}
