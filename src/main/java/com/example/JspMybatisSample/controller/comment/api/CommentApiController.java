package com.example.JspMybatisSample.controller.comment.api;

import com.example.JspMybatisSample.service.comment.CommentQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentApiController {

    private final CommentQueryService commentQueryService;

//    @PostMapping("/")

}
