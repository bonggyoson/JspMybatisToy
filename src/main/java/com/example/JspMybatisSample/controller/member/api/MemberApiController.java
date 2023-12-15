package com.example.JspMybatisSample.controller.member.api;

import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.member.MemberCommandService;
import com.example.JspMybatisSample.service.member.MemberQueryService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberApiController {

    private final MemberQueryService memberQueryService;

    private final MemberCommandService memberCommandService;

    @PostMapping("/join")
    public ResponseEntity<CommonResponse<?>> join(InsertMemberDto insertMemberDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.res(HttpStatus.CREATED, "회원 가입 성공",
                memberQueryService.insertMember(insertMemberDto)));
    }

    @PostMapping("")
    public ResponseEntity<CommonResponse<?>> selectMembers(
        @RequestParam(required = false, defaultValue = "1") int page) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "회원 조회 성공",
                new PageInfo<>(memberCommandService.selectMembers(page))));
    }
}
