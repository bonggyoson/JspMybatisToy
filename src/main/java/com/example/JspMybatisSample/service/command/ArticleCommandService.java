package com.example.JspMybatisSample.service.command;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleCommandService {

    private final ArticleMapper articleMapper;

    public List<ArticleDto> selectArticles() {
        return articleMapper.selectArticles();
    }

    public ArticleDto selectArticle(long articleId) {
        return articleMapper.selectArticle(articleId);
    }

}
