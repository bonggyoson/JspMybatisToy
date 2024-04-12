package com.example.JspMybatisSample.domain.article.dto;

import com.example.JspMybatisSample.domain.comment.dto.CommentDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithoutPasswordDto;
import com.example.JspMybatisSample.global.common.BaseEntity;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleDto extends BaseEntity {

    /* 번호 (PK) */
    private Long articleId;

    /* 회원 (FK) */
    private MemberWithoutPasswordDto member;

    /* 제목 */
    private String articleTitle;

    /* 내용 */
    private String articleContent;

    /* 조회수 */
    private int articleViewCount;

    /* 댓글 */
    private List<CommentDto> comment;

}
