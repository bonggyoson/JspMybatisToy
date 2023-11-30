package com.example.JspMybatisSample.domain.article.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateArticleDto {

    /* 제목 */
    @NotNull
    private String articleTitle;

    /* 내용 */
    @NotNull
    private String articleContent;

    /* 작성자 */
    @NotNull
    private String articleWriter;

}
