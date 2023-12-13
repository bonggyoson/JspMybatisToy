package com.example.JspMybatisSample.domain.article.dto;

import com.example.JspMybatisSample.global.common.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto extends BaseEntity {

    /* 번호 (PK) */
    private Long articleId;

    /* 제목 */
    private String articleTitle;

    /* 내용 */
    private String articleContent;

    /*작성자 */
    private String articleWriter;

    /* 조회수 */
    private int articleViewCount;

}
