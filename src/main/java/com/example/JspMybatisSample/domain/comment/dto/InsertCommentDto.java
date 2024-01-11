package com.example.JspMybatisSample.domain.comment.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class InsertCommentDto {

    @NotNull
    private Long articleId;

    @NotNull
    private Long memberId;

    @NotNull
    private String commentContent;

}
