package com.example.JspMybatisSample.global.common.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pagination {

    // 현재 페이지 번호
    private int currPageNo;

    // 현재 페이지 범위
    private int currPageRange;

    // 한 페이지 당 출력할 데이터 개수, 초기값 20
    private int dataCntPerPage = 20;

    // 페이지 범위, 초기값 10
    private int pageRange = 10;

    // 전체 데이터 개수
    private int totalDataCnt;

    // 전체 페이지 개수
    private int totalPageCnt;

    // 시작 페이지 번호
    private int startPageNo;

    // 끝 페이지 번호
    private int endPageNo;

    // 이전 페이지 화살표
    private boolean prev;

    // 다음 페이지 화살표
    private boolean next;

    public void pageInfo(int currPageNo, int pageRange, int totalDataCnt) {
        this.currPageNo = currPageNo;
        this.pageRange = pageRange;
        this.totalDataCnt = totalDataCnt;

        // 전체 페이지 개수
        this.totalPageCnt = (int) Math.ceil((double) totalDataCnt / dataCntPerPage);

        // 시작 페이지 번호
        this.startPageNo = (currPageRange - 1) * pageRange + 1;

        // 끝 페이지 번호
        this.endPageNo = currPageRange * pageRange;

        // 이전 페이지
        this.prev = currPageRange == 1 ? false : true;

        // 다음 페이지
        this.next = endPageNo > totalPageCnt ? false : true;

        if (this.endPageNo > this.totalPageCnt) {
            this.endPageNo = this.totalPageCnt;
            this.next = false;

        }
    }

}
