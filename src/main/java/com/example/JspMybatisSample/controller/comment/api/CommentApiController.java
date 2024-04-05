package com.example.JspMybatisSample.controller.comment.api;

import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.comment.CommentQueryService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/comment")
public class CommentApiController {

    private final CommentQueryService commentQueryService;

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<?>> insertComment(
        @RequestBody final InsertCommentDto insertCommentDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(CommonResponse.res("댓글 등록 성공",
                commentQueryService.insertComment(insertCommentDto)));

    }

}
