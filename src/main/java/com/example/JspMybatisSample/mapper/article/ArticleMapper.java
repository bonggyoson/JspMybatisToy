package com.example.JspMybatisSample.mapper.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleMapper {

    Page<ArticleDto> selectArticles();

    ArticleDto selectArticle(long articleId);

    void selectArticlePlusViewCount(long articleId);

    int insertArticle(InsertArticleDto insertArticleDto);

    int updateArticle(long articleId, @Param("updateArticle")UpdateArticleDto updateArticleDto);

    int deleteArticle(long articleId);
}
