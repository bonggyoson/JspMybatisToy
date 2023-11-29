package com.example.JspMybatisSample.mapper.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<ArticleDto> selectArticles();

    ArticleDto selectArticle(long articleId);

    int insertArticle(InsertArticleDto insertArticleDto);

    int updateArticle(UpdateArticleDto updateArticleDto);

    int deleteArticle(long articleId);
}
