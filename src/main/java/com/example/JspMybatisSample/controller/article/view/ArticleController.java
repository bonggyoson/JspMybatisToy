package com.example.JspMybatisSample.controller.article.view;

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

    @GetMapping("")
    public String selectArticles() {

        return "article/article_list";
    }

    @GetMapping("/{articleId}")
    public String selectArticle(Model model, @PathVariable long articleId) {

        model.addAttribute("articleId", articleId);
        return "article/article_detail";
    }

    @GetMapping("/insertArticle")
    public String insertArticle() {
        return "article/article_insert";
    }

    @GetMapping("/updateArticle/{articleId}")
    public String updateArticle(Model model, @PathVariable long articleId) {

        model.addAttribute("articleId", articleId);
        return "article/article_update";
    }
}
