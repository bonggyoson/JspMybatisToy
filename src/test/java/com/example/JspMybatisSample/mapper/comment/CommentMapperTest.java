package com.example.JspMybatisSample.mapper.comment;

import com.example.JspMybatisSample.common.config.BaseTestConfig;
import com.example.JspMybatisSample.domain.article.dto.ArticleDto;
import com.example.JspMybatisSample.domain.article.dto.InsertArticleDto;
import com.example.JspMybatisSample.domain.comment.dto.CommentDto;
import com.example.JspMybatisSample.domain.comment.dto.InsertCommentDto;
import com.example.JspMybatisSample.domain.member.dto.InsertMemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto;
import com.example.JspMybatisSample.domain.member.dto.MemberDto.MemberWithPasswordDto;
import com.example.JspMybatisSample.global.config.DatabaseConfig;
import com.example.JspMybatisSample.mapper.article.ArticleMapper;
import com.example.JspMybatisSample.mapper.member.MemberMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@AutoConfigureTestDatabase(replace = NONE)
@ImportAutoConfiguration(DatabaseConfig.class)
@MybatisTest
public class CommentMapperTest extends BaseTestConfig {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private CommentMapper commentMapper;

    @BeforeEach
    public void beforeEach() {

    }

    @Test
    @DisplayName("Insert Comment")
    void insertComment() throws Exception {
        // given
        DummyMember dummyMember = new DummyMember();
        DummyArticle dummyArticle = new DummyArticle();
        DummyComment dummyComment = new DummyComment();

        // 회원 가입
        memberMapper.insertMember(
            new InsertMemberDto(dummyMember.getMemberEmail(), dummyMember.getMemberPassword(),
                dummyMember.getMemberName()));

        MemberWithPasswordDto member = memberMapper.selectMember(dummyMember.getMemberEmail());

        // 게시글 등록
        InsertArticleDto article = new InsertArticleDto(dummyArticle.getArticleTitle(),
            dummyArticle.getArticleContent(), member.getMemberId());
        articleMapper.insertArticle(article);

        // when
        commentMapper.insertComment(
            new InsertCommentDto(article.getArticleId(), member.getMemberId(),
                dummyComment.getCommentContent()));

        List<CommentDto> comments = commentMapper.selectComments();

        // then
        assertThat(comments).anySatisfy(comment -> {
            assertThat(comment.getCommentContent()).isEqualTo(dummyComment.getCommentContent());
        });
    }
}
