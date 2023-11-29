package com.example.JspMybatisSample.controller.article.view;

import com.example.JspMybatisSample.service.command.ArticleCommandService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    private final ArticleCommandService articleService;

    @GetMapping("")
    public String selectArticles() {

        return "article/article_list";
    }

    @GetMapping("/{articleId}")
    public String selectArticle() {

        return "article/article_detail";
    }

    @GetMapping("/insertArticle")
    public String insertArticle() {
        return "article/article_insert";
    }

    @GetMapping("/updateArticle")
    public String updateArticle() {
        return "article/article_update";
    }
}
