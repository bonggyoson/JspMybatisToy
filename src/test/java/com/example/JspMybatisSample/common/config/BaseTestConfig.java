package com.example.JspMybatisSample.common.config;

import com.example.JspMybatisSample.service.ArticleService;
import org.springframework.boot.test.mock.mockito.MockBean;

public class BaseTestConfig {

    @MockBean
    private ArticleService articleService;

}
