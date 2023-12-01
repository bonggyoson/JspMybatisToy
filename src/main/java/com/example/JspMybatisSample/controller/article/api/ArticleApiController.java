package com.example.JspMybatisSample.controller.article.api;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.command.ArticleCommandService;
import com.example.JspMybatisSample.service.query.ArticleQueryService;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        @RequestParam(required = false, defaultValue = "1") Integer page) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 조회 성공",
                new PageInfo<>(articleCommandService.selectArticles(page))
            ));
    }

    @PostMapping("/{articleId}")
    public ResponseEntity<CommonResponse<ArticleDto>> selectArticle(
        @PathVariable long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 상세 조회 성공",
                articleCommandService.selectArticle(articleId)));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<?>> insertArticle(
        InsertArticleDto insertArticleDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.res(HttpStatus.CREATED, "게시글 등록 성공",
                articleQueryService.insertArticle(insertArticleDto)));
    }

    @PutMapping("/{articleId}/update")
    public ResponseEntity<CommonResponse<?>> updateArticle(
        @PathVariable long articleId, @RequestBody UpdateArticleDto updateArticleDto) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 수정 성공",
                articleQueryService.updateArticle(articleId, updateArticleDto)));
    }

    @DeleteMapping("/{articleId}/delete")
    public ResponseEntity<CommonResponse<?>> deleteArticle(@PathVariable long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 삭제 성공",
                articleQueryService.deleteArticle(articleId)));
    }
}
