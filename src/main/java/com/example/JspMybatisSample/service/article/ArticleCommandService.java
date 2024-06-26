package com.example.JspMybatisSample.service.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleCommandService {

    private final ArticleMapper articleMapper;

    public Page<ArticleDto> selectArticles(int pageNum, String search) {
        PageHelper.startPage(pageNum, 10);

        return articleMapper.selectArticles(search);
    }

    @Transactional
    public ArticleDto selectArticle(long articleId) {

        // 조회수 증가
        articleMapper.updateArticlePlusViewCount(articleId);

        return articleMapper.selectArticle(articleId);
    }

    public Page<ArticleDto> searchArticles(String search, int pageNum) {
        PageHelper.startPage(pageNum, 10);

        return articleMapper.searchArticles(search);
    }

}
