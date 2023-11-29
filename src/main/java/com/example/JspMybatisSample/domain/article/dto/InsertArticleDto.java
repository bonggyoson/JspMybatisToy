package com.example.JspMybatisSample.domain.article.dto;

import com.sun.istack.internal.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class InsertArticleDto {

    /* 제목 */
    @NotNull
    private String articleTitle;

    /* 내용 */
    @NotNull
    private String articleContent;

    /*작성자 */
    @NotNull
    private String articleWriter;

}
