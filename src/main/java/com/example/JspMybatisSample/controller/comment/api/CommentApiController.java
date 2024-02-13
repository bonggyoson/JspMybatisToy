package com.example.JspMybatisSample.controller.comment.api;

import com.example.JspMybatisSample.domain.article.dto.UpdateArticleDto;
import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.domain.comment.dto.UpdateCommentDto;
import com.example.JspMybatisSample.global.common.CommonResponse;
import com.example.JspMybatisSample.service.comment.CommentCommandService;
import com.example.JspMybatisSample.service.comment.CommentQueryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/comment")
public class CommentApiController {

    private final CommentCommandService commentCommandService;

    private final CommentQueryService commentQueryService;

    @PostMapping("/{articleId}")
    public ResponseEntity<CommonResponse<?>> selectComments(@PathVariable long articleId) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.res("댓글 조회 성공",
                        commentCommandService.selectComments(articleId)));
    }

    @PostMapping("/insert")
    public ResponseEntity<CommonResponse<?>> insertComment(
            @RequestBody final InsertCommentDto insertCommentDto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.res("댓글 등록 성공",
                        commentQueryService.insertComment(insertCommentDto)));
    }

    @PutMapping("/{commentId}/update")
    public ResponseEntity<CommonResponse<?>> updateComment(
            @PathVariable long commentId, @RequestBody UpdateCommentDto updateCommentDto) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(CommonResponse.res("댓글 수정 성공",
                        commentQueryService.updateComment(commentId, updateCommentDto)));
    }

    @DeleteMapping("/{articleId}/delete")
    public ResponseEntity<CommonResponse<?>> deleteComment(@PathVariable long commentId) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(CommonResponse.res("댓글 삭제 성공",
                        commentQueryService.deleteComment(commentId)));
    }
}
