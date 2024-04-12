package com.example.JspMybatisSample.domain.comment.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class InsertCommentDto {

    /* 게시글 번호 (FK)*/
    @NotNull
    private Long articleId;

    /* 회원 번호 (FK) */
    @NotNull
    private Long memberId;

    /* 내용*/
    @NotNull
    private String commentContent;

    public InsertCommentDto(Long articleId, Long memberId, String commentContent) {
        this.articleId = articleId;
        this.memberId = memberId;
        this.commentContent = commentContent;
    }

}
