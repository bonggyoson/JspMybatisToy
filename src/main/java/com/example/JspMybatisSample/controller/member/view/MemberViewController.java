package com.example.JspMybatisSample.controller.member.view;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberViewController {

    @GetMapping("/join")
    public String join() {
        return "member/member_join";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error,
        @RequestParam(required = false) String exception, Model model) {

        model.addAttribute("error", error);
        model.addAttribute("exception", exception);

        return "member/member_login";
    }

    @GetMapping("/resetPassword")
    public String resetPassword() {
        return "member/member_resetPassword";
    }
}
