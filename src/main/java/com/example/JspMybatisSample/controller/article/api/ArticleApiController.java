package com.example.JspMybatisSample.controller.article.api;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.search.SearchDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.command.ArticleCommandService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleApiController {

    private final ArticleCommandService articleService;

    @PostMapping("")
    public ResponseEntity<CommonResponse<List<ArticleDto>>> selectArticles(
        SearchDto searchDto) {

        List<ArticleDto> articles = articleService.selectArticles();

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 리스트 조회 성공", articles));
    }

    @PostMapping("/{articleId}")
    public ResponseEntity<CommonResponse<ArticleDto>> selectArticle(Model model,
        @PathVariable long articleId) {
        ArticleDto article = articleService.selectArticle(articleId);

        return ResponseEntity.status(HttpStatus.OK)
            .body(CommonResponse.res(HttpStatus.OK, "게시글 상세 조회 성공", article));
    }

}
