package com.example.JspMybatisSample.domain.article.dto;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class InsertArticleDto {

    /* 게시글 번호 (PK) */
    private long articleId;

    /* 제목 */
    @NotNull
    private String articleTitle;

    /* 내용 */
    @NotNull
    private String articleContent;

    /*작성자 */
    @NotNull
    private long memberId;

}
