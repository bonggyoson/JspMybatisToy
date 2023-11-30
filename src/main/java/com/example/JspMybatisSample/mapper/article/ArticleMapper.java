package com.example.JspMybatisSample.mapper.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    Page<ArticleDto> selectArticles();

    int selectArticlesCount();

    ArticleDto selectArticle(long articleId);

    int insertArticle(InsertArticleDto insertArticleDto);

    int updateArticle(UpdateArticleDto updateArticleDto);

    int deleteArticle(long articleId);
}
