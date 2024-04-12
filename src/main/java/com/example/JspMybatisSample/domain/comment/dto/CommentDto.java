package com.example.JspMybatisSample.domain.comment.dto;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto extends BaseEntity {

    /* 댓글 번호 (PK) */
    private Long commentId;

//    /* 게시글 (FK) */
//    private ArticleDto article;

    /* 회원 (FK) */
    private MemberWithoutPasswordDto member;

    /* 댓글 내용 */
    private String commentContent;

}
