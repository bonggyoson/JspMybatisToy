package com.example.JspMybatisSample.controller.article;

import com.example.JspMybatisSample.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("")
    public String selectArticles(Model model) {
//        model.addAttribute("articles", articleService.selectArticles());

        return "article/article_list";
    }

    @GetMapping("/{articleId}")
    public String selectArticle(Model model, @PathVariable long articleId) {
        model.addAttribute("article", articleService.selectArticle(articleId));

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
