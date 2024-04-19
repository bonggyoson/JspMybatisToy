package com.example.JspMybatisSample.controller.mypage.api;

import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.global.util.FileStore;
import com.example.JspMybatisSample.service.mypage.MyPageCommandService;
import com.github.pagehelper.PageInfo;
import java.net.MalformedURLException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api/myPage")
@RequiredArgsConstructor
public class MyPageApiController {

    private final MyPageCommandService myPageCommandService;

    private final FileStore fileStore;

    @PostMapping("/{memberId}")
    public ResponseEntity<CommonResponse<?>> selectMyPageMemberInfo(@PathVariable long memberId) {

        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.res("마이페이지 회원 정보 조회 성공",
            myPageCommandService.selectMyPageMember(memberId)));
    }

    @PostMapping("/article/{memberId}")
    public ResponseEntity<CommonResponse<?>> selectMyPageArticleInfo(
        @RequestParam(required = false, defaultValue = "1") int page, @PathVariable long memberId) {

        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.res("마이페이지 게시글 정보 조회 성공",
            new PageInfo<>(myPageCommandService.selectMyPageArticle(page, memberId))));
    }

    @PostMapping("/images/{filename}")
    public Resource downloadImage(@PathVariable String filename) throws MalformedURLException {

        return new UrlResource("file:" + fileStore.getFullPath(filename));
    }
}
