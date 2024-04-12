package com.example.JspMybatisSample.service.command;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import com.example.JspMybatisSample.service.article.ArticleCommandService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ArticleCommandServiceTest {

    @Autowired
    ArticleCommandService articleCommandService;

    @Autowired
    ArticleMapper articleMapper;

    @Test
    void selectArticlesPaging() {
        int perPage = 10;

        PageHelper.startPage(2, perPage);
        Page<ArticleDto> articleDtos = articleMapper.selectArticles("");
        for (ArticleDto articleDto : articleDtos) {
            System.out.println("articleDto = " + articleDto.getArticleId());
        }


    }

}