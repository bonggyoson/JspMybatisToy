package com.example.JspMybatisSample.controller.article.api;

import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.article.ArticleCommandService;
import com.example.JspMybatisSample.service.article.ArticleQueryService;
import com.github.pagehelper.PageInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleApiController {

    private final ArticleCommandService articleCommandService;

    private final ArticleQueryService articleQueryService;

    @PostMapping("")
    public ResponseEntity<CommonResponse<?>> selectArticles(
        @RequestParam(required = false, defaultValue = "1") int page,
        @RequestParam(required = false, defaultValue = "") String search) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("게시글 조회 성공",
                new PageInfo<>(articleCommandService.selectArticles(page, search))
            ));
    }

    @PostMapping("/{articleId}")
    public ResponseEntity<CommonResponse<?>> selectArticle(
        @PathVariable long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res("게시글 상세 조회 성공",
                articleCommandService.selectArticle(articleId)));
    }

    @PostMapping("/search")
    public ResponseEntity<CommonResponse<?>> searchArticles(@RequestParam String search,
        @RequestParam(required = false, defaultValue = "1") int page) {

        return ResponseEntity.status(HttpStatus.OK).body(CommonResponse.res("게시글 검색 성공",
            new PageInfo<>(articleCommandService.searchArticles(search, page))));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<?>> insertArticle(
        @RequestBody final InsertArticleDto insertArticleDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.res("게시글 등록 성공",
                articleQueryService.insertArticle(insertArticleDto)));
    }

    @PutMapping("/{articleId}/update")
    public ResponseEntity<CommonResponse<?>> updateArticle(
        @PathVariable long articleId, @RequestBody UpdateArticleDto updateArticleDto) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(CommonResponse.res("게시글 수정 성공",
                articleQueryService.updateArticle(articleId, updateArticleDto)));
    }

    @DeleteMapping("/{articleId}/delete")
    public ResponseEntity<CommonResponse<?>> deleteArticle(@PathVariable long articleId) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
            .body(CommonResponse.res("게시글 삭제 성공",
                articleQueryService.deleteArticle(articleId)));
    }
}
