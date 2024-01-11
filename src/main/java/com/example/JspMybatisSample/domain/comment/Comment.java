package com.example.JspMybatisSample.domain.comment;

import com.example.JspMybatisSample.domain.article.Article;
import com.example.JspMybatisSample.domain.member.Member;
import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.Getter;

@Getter
public class Comment extends BaseEntity {

    /* 번호 (PK)*/
    private Long commentId;

    /* 게시글 (FK) */
    private Article article;

    /* 회원 (FK) */
    private Member member;

    /* 댓글 내용 */
    private String commentContent;

}
