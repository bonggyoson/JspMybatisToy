package com.example.JspMybatisSample.global.common.page;

import lombok.Getter;

@Getter
public class Page {

    // 현재 페이지 번호
    private int pageNum;

    // 페이지 당 출력할 데이터 개수
    private int dataSize;

    // 전체 페이지 사이즈
    private int pageSize;

}
