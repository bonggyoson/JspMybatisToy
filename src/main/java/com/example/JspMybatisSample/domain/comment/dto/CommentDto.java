package com.example.JspMybatisSample.domain.comment.dto;

import com.example.JspMybatisSample.global.common.BaseEntity;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto extends BaseEntity {

    /* 번호 (PK) */
    private Long articleId;

    /* 회원 (FK) */
    private Long memberId;

    /* 댓글 */
    private String commentContent;
}
