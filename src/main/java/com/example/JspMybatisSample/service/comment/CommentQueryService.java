package com.example.JspMybatisSample.service.comment;

import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.mapper.comment.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class CommentQueryService {

    private final CommentMapper commentMapper;

    public int insertComment(InsertCommentDto insertCommentDto) {
        return commentMapper.insertComment(insertCommentDto);
    }
}
