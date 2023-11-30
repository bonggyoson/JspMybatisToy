package com.example.JspMybatisSample.global.config;

import com.github.pagehelper.PageInterceptor;
import java.util.Properties;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.example.JspMybatisSample.mapper.**")
@RequiredArgsConstructor
public class MyBatisConfig {

    private final ApplicationContext applicationContext;

    @Bean
    public SqlSessionFactoryBean SqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
        throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setConfigLocation(
            applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(
            applicationContext.getResources("classpath:/mybatis/mapper/*.xml"));

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();

        properties.put("helperDialect", "postgresql");
        properties.put("reasonable", "true");
        pageInterceptor.setProperties(properties);
        sqlSessionFactoryBean.setPlugins(pageInterceptor);

        return sqlSessionFactoryBean;
    }

    @Bean
    public SqlSessionTemplate SqlSessionTemplate(
        @Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}