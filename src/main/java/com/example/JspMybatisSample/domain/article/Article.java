package com.example.JspMybatisSample.domain.article;

import com.example.JspMybatisSample.global.common.BaseEntity;
import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

/**
 * 게시판 도메인
 */
@Getter
@NoArgsConstructor
public class Article extends BaseEntity {

    /* 번호 (PK) */
    private Long articleId;

    /* 제목 */
    private String articleTitle;

    /* 내용 */
    private String articleContent;

    /* 작성자 */
    private String articleWriter;

    /* 조회수 */
    private int ArticleViewCount;
}
