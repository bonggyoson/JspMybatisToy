package com.example.JspMybatisSample.domain.article.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;

@Getter
public class InsertArticleDto {

    /* 게시글 번호 (PK) */
    private long articleId;

    /* 제목 */
    @NotNull(message = "제목을 입력해 주세요.")
    private String articleTitle;

    /* 내용 */
    @NotNull(message = "내용을 입력해 주세요.")
    private String articleContent;

    /*작성자 */
    @NotNull(message = "회원 정보가 없습니다.")
    private long memberId;

    public InsertArticleDto(String articleTitle, String articleContent, long memberId) {
        this.articleTitle = articleTitle;
        this.articleContent = articleContent;
        this.memberId = memberId;
    }

}
