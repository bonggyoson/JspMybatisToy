package com.example.JspMybatisSample.api.controller.article;

import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.JspMybatisSample.common.config.BaseControllerTestConfig;
import com.example.JspMybatisSample.common.config.BaseTestConfig;
import com.example.JspMybatisSample.controller.article.api.ArticleApiController;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@Transactional
class ArticleApiControllerTest extends BaseControllerTestConfig {

    @Test
    @DisplayName("Select Articles API Test")
    void selectArticlesApiTest() throws Exception {
        // given
        int page = new Random().nextInt(5);
        String search = "test";

        // when
        mockMvc.perform(post("/api/article?page=" + page + "&search=" + search))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    @DisplayName("Select Article API Test")
    void selectArticleApiTest() throws Exception {
        // given
        int articleId = new Random().nextInt(5);

        // when
        mockMvc.perform(post("/api/article/" + articleId))
            .andExpect(status().isOk())
            .andDo(print());
    }

}