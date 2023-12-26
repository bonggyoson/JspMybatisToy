package com.example.JspMybatisSample.controller.member.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    @GetMapping("/join")
    public String join() {
        return "member/member_join";
    }

    @GetMapping("/login")
    public String login() {
        return "member/member_login";
    }
}
