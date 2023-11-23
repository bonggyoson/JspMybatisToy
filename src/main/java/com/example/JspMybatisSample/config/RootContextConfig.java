package com.example.JspMybatisSample.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 루트 컨텍스트 설정
 */
@Configuration
@Import({
    MyBatisConfig.class,
    DatabaseConfig.class
})
@ComponentScan
public class RootContextConfig {

}
