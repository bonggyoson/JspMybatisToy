package com.example.JspMybatisSample.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().antMatchers("/static/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()    // CSRF 공격 방어 해제
            .authorizeRequests()        // URI에 따른 페이지 권한 부여 메소드, antMatchers 기능을 위한 메소드
            .antMatchers("/article/**").authenticated()         // 특정 URL 접근 시 인가가 필요한 URI
            .anyRequest().permitAll()   // 특정 URI을 제외한 나머지 URI은 전부 인가
            .and()
            .formLogin()
            .loginPage("/login")
            // 파라미터 명칭 변경
            .usernameParameter("memberEmail")
            .passwordParameter("memberPassword")
            // 로그인 요청 url
            .loginProcessingUrl("/api/member/login")
            // 로그인 실패 url
            .failureUrl("/login")
            // default 로그인 성공 url
            .defaultSuccessUrl("/")
            .and()
            .build();
    }

}
