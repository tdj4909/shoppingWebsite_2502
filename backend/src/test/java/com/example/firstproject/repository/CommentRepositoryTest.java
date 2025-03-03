package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class CommentRepositoryTest {
    @Autowired
    CommentRepository commentRepository;
    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        
        Long articleId = 1L;
        List<Comment> comments = commentRepository.findByArticleId(articleId);

        Article article = new Article(1L, "가가가가", "1111");
        Comment a = new Comment(1L, article, "Park", "굿");
        Comment b = new Comment(2L, article, "Kim", "아");
        Comment c = new Comment(3L, article, "Choi", "쇼");
        List<Comment> expected = Arrays.asList(a,b,c);
        
        assertEquals(expected.toString(), comments.toString(), "1번 글의 모든 댓글 출력");
    }

}