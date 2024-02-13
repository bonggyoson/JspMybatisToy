 package com.example.JspMybatisSample.service.comment;

 import com.example.JspMybatisSample.domain.comment.dto.CommentDto;
 import com.example.JspMybatisSample.mapper.comment.CommentMapper;
 import java.util.List;
 import lombok.RequiredArgsConstructor;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.stereotype.Service;

 @Service
 @RequiredArgsConstructor
 @Slf4j
public class CommentCommandService {

  private final CommentMapper commentMapper;

     public List<CommentDto> selectComments(long articleId) {
         return commentMapper.selectComments(articleId);
     }


}
