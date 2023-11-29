package com.example.JspMybatisSample.domain.search;

import lombok.Getter;

/**
 * Article 조회 DTO
 *
 * @author bonggyoson
 * @version 1.0.0 2023.11.29
 */
@Getter
public class SearchDto {

    // 페이지 번호
    private int pageNum;
    // 페이지 당 출력될 게시글 개수
    private int pageSize;
    // 검색 시 입력될 타입
    private String searchType;
    // 검색 시 입력될 검색어
    private String searchContent;
}
