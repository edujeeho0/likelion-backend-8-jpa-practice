package com.example.jpapractice.book.repo;

import com.example.jpapractice.book.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}
