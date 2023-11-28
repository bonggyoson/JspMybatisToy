package com.example.JspMybatisSample.api.controller.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.ArticleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleApiController {

    private final ArticleService articleService;

    @PostMapping("")
    public ResponseEntity<CommonResponse<List<ArticleDto>>> selectArticles() {

        List<ArticleDto> articles = articleService.selectArticles();

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 리스트 조회 성공", articles));
    }
}
