package com.example.JspMybatisSample.controller.mypage.view;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/myPage")
public class MyPageViewController {

    @GetMapping("/{memberId}")
    public String getMyPage(Model model) {

        return "mypage/mypage_member";
    }

    @GetMapping("/article")
    public String getMyPageArticle(Model model) {

        return "mypage/mypage_article";
    }
}
