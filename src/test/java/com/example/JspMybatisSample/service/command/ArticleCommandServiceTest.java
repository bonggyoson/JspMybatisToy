package com.example.JspMybatisSample.service.command;

import static org.junit.jupiter.api.Assertions.*;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.github.pagehelper.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ArticleCommandServiceTest {

    @Autowired
    ArticleCommandService articleCommandService;

    @Test
    void selectArticlesPaging() {
        int perPage = 10;

        Page<ArticleDto> articleDtos = articleCommandService.selectArticles(perPage);
        System.out.println("articleDtos = " + articleDtos);

    }

}