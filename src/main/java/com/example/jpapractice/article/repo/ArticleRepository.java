package com.example.jpapractice.article.repo;

import com.example.jpapractice.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {}
