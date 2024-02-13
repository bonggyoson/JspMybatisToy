package com.example.JspMybatisSample.mapper.comment;

import com.example.JspMybatisSample.domain.comment.dto.CommentDto;
import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.domain.comment.dto.UpdateCommentDto;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

    List<CommentDto> selectComments(long articleId);

    CommentDto selectComment();

    int insertComment(InsertCommentDto insertCommentDto);

    int updateComment(long commentId, UpdateCommentDto updateCommentDto);

    int deleteComment(long commentId);
}
