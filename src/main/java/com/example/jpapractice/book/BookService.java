package com.example.jpapractice.book;

import com.example.jpapractice.book.dto.BookDto;
import com.example.jpapractice.book.entity.Author;
import com.example.jpapractice.book.entity.Book;
import com.example.jpapractice.book.repo.AuthorRepository;
import com.example.jpapractice.book.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BookDto create(Long authorId, BookDto dto) {
        Author author = authorRepository.findById(authorId)
                .orElseThrow();
        Book book = new Book(
                dto.getTitle(),
                dto.getSummary(),
                dto.getRating(),
                author
        );

        return BookDto.fromEntity(bookRepository.save(book), true);
    }

    public BookDto read(Long bookId) {
        return BookDto.fromEntity(bookRepository.findById(bookId).orElseThrow(),
                true);
    }

    public List<BookDto> readAll() {
        List<BookDto> books = new ArrayList<>();
        for (Book book: bookRepository.findAll()) {
            books.add(BookDto.fromEntity(book, true));
        }
        return books;
    }

    public BookDto update(Long bookId, BookDto dto) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow();

        book.setSummary(dto.getSummary());
        book.setRating(dto.getRating());
        return BookDto.fromEntity(bookRepository.save(book), true);
    }

    public void delete(Long bookId) {
        bookRepository.delete(bookRepository.findById(bookId).orElseThrow());
    }
}
