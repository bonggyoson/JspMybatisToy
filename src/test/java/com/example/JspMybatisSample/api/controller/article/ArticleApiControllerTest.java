package com.example.JspMybatisSample.api.controller.article;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.JspMybatisSample.common.config.BaseTestConfig;
import com.example.JspMybatisSample.controller.article.api.ArticleApiController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ArticleApiController.class)
class ArticleApiControllerTest extends BaseTestConfig {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("게시글 리스트 조회 API 테스트")
    void selectArticlesApiTest() throws Exception {
        // given

        // when
        mockMvc.perform(get("/api/article"))
            .andExpect(status().isOk());
    }

}