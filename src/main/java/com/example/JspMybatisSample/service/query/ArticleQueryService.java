package com.example.JspMybatisSample.service.query;

import com.example.JspMybatisSample.domain.article.Article;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleQueryService {

    private final ArticleMapper articleMapper;

    public int insertArticle(InsertArticleDto insertArticleDto) {
        return articleMapper.insertArticle(insertArticleDto);
    }

    public int updateArticle(UpdateArticleDto updateArticleDto) {
        return articleMapper.updateArticle(updateArticleDto);
    }

    public int deleteArticle(long articleId) {
        return articleMapper.deleteArticle(articleId);
    }
}
