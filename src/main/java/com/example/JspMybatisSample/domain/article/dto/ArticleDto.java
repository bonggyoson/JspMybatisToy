package com.example.JspMybatisSample.domain.article.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ArticleDto {

    /* 번호 (PK) */
    private Long articleId;

    /* 제목 */
    private String articleTitle;

    /* 내용 */
    private String articleContent;

    /*작성자 */
    private String articleWiter;

    /* 조회수 */
    private int articleView;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정일 */
    private LocalDateTime updatedAt;
}
