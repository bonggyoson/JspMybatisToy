package com.example.JspMybatisSample.domain.article;

import lombok.Getter;

import java.time.LocalDateTime;
import lombok.NoArgsConstructor;

/**
 * 게시판 도메인
 */
@Getter
@NoArgsConstructor
public class Article {

    /* 번호 (PK) */
    private Long id;

    /* 제목 */
    private String title;

    /* 내용 */
    private String content;

    /* 작성자 */
    private String writer;

    /* 조회수 */
    private int viewCnt;

    /* 등록일 */
    private LocalDateTime createdAt;

    /* 수정일 */
    private LocalDateTime updatedAt;
}
