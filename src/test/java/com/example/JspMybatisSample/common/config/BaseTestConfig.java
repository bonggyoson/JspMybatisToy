package com.example.JspMybatisSample.common.config;

import com.github.javafaker.Faker;

import java.util.Locale;

import lombok.Getter;

public class BaseTestConfig {

//    @MockBean
//    private ArticleCommandService articleService;

    static public Faker faker = new Faker(Locale.ENGLISH);

    @Getter
    public class DummyMember {

        String memberEmail = faker.internet().emailAddress();
        String memberPassword = faker.letterify("????");
        String memberName = faker.name().fullName();
    }

    @Getter
    public class DummyArticle {

        String articleTitle = faker.letterify("Article test title");
        String articleContent = faker.letterify("Article test Content");
    }

    @Getter
    public class DummyComment {

        String commentContent = faker.letterify("DummyData");
    }
}
