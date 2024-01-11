package com.example.JspMybatisSample.global.config.security;

import com.example.JspMybatisSample.service.member.MemberDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AuthenticationFailureHandler customFailureHandler;

    private final MemberDetailsService memberDetailsService;

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().antMatchers("/static/**");
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(memberDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
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
            // 로그인 실패 핸들러
            .failureHandler(customFailureHandler)
            // default 로그인 성공 url
            .defaultSuccessUrl("/")
            .and()
            // 로그아웃
            .logout()
            // 로그아웃 url
            .logoutUrl("/api/member/logout")
            .logoutSuccessUrl("/login")
            .deleteCookies("JSESSIONID")
            .and()
            .build();
    }

}
