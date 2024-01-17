package com.example.JspMybatisSample.service.article;

import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ArticleQueryService {

    private final ArticleMapper articleMapper;

    public int insertArticle(InsertArticleDto insertArticleDto) {
        return articleMapper.insertArticle(insertArticleDto);
    }

    public int updateArticle(long articleId, UpdateArticleDto updateArticleDto) {
        return articleMapper.updateArticle(articleId, updateArticleDto);
    }

    public int deleteArticle(long articleId) {
        return articleMapper.deleteArticle(articleId);
    }
}
