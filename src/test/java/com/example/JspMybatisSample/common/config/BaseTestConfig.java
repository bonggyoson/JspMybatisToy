package com.example.JspMybatisSample.common.config;

import com.example.JspMybatisSample.service.command.ArticleCommandService;
import org.springframework.boot.test.mock.mockito.MockBean;

public class BaseTestConfig {

    @MockBean
    private ArticleCommandService articleService;

}
