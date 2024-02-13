package com.example.JspMybatisSample.service.comment;

import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.domain.comment.dto.UpdateCommentDto;
import com.example.JspMybatisSample.mapper.comment.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class CommentQueryService {

    private final CommentMapper commentMapper;

    public int insertComment(InsertCommentDto insertCommentDto) {
        return commentMapper.insertComment(insertCommentDto);
    }

    public int updateComment(long commentId, UpdateCommentDto updateCommentDto) {
        return commentMapper.updateComment(commentId, updateCommentDto);
    }

    public int deleteComment(long commentId) {
        return commentMapper.deleteComment(commentId);
    }
}
