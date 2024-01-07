package com.example.jpapractice.book.repo;

import com.example.jpapractice.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}
