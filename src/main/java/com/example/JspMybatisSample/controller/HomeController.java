package com.example.JspMybatisSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("")
    public String home() {
        return "home";
    }

    @GetMapping("/join")
    public String join() {
        return "member/member_join";
    }

    @GetMapping("/login")
    public String login() {
        return "member/member_login";
    }
}
