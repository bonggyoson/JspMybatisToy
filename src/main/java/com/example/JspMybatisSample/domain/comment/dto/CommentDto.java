 package com.example.JspMybatisSample.domain.comment.dto;

import com.example.JspMybatisSample.global.common.BaseEntity;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CommentDto extends BaseEntity {

    @NotNull
    private Long articleId;

    @NotNull
    private Long memberId;

    @NotNull
    private String commentContent;
}
