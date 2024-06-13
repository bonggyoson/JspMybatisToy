package com.example.JspMybatisSample.common.config;

import static java.lang.Boolean.TRUE;

import com.github.javafaker.Faker;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import java.util.Locale;

import lombok.Getter;

public class BaseTestConfig {

//    @MockBean
//    private ArticleCommandService articleService;
    
    protected static FixtureMonkey monkey() {
        return FixtureMonkey.builder().objectIntrospector(
                ConstructorPropertiesArbitraryIntrospector.INSTANCE)
            .defaultNotNull(TRUE)
            .build();
    }

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
