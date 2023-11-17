package com.example.JspMybatisSample.mapper.article;

import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    List<ArticleDto> selectArticles();

    ArticleDto selectArticle(long articleId);

    int insertArticle(ArticleDto articleDto);

    int updateArticle(ArticleDto articleDto);

    void deleteArticle(long articleId);


}
