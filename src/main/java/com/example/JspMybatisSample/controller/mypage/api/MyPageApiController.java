package com.example.JspMybatisSample.controller.mypage.api;

import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.mypage.MyPageCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MyPageApiController {

    private final MyPageCommandService myPageCommandService;

    @PostMapping("/{memberId}")
    public ResponseEntity<CommonResponse<?>> selectMyPageMemberInfo(@PathVariable long memberId) {

        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.res("마이페이지 회원 정보 조회 성공",
                myPageCommandService.selectMyPageMember(memberId)));
    }
}
