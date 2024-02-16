package com.example.JspMybatisSample.controller.mypage.api;

import com.example.JspMybatisSample.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/mypage")
@RequiredArgsConstructor
public class MyPageApiController {

    @PostMapping("")
    public ResponseEntity<CommonResponse<?>> selectMyPage() {
        return null;
    }
}
