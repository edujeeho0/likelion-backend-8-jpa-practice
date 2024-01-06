package com.example.jpapractice.article.repo;

import com.example.jpapractice.article.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}
