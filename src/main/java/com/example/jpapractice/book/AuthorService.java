package com.example.jpapractice.book;

import com.example.jpapractice.book.dto.AuthorDto;
import com.example.jpapractice.book.entity.Author;
import com.example.jpapractice.book.repo.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorDto create(AuthorDto dto) {
        Author author = new Author(
                dto.getName(), dto.getDebutYear()
        );
        return AuthorDto.fromEntity(repository.save(author));
    }

    public List<AuthorDto> readAll() {
        List<AuthorDto> authors = new ArrayList<>();
        for (Author author: repository.findAll()) {
            authors.add(AuthorDto.fromEntity(author));
        }

        return authors;
    }

    public AuthorDto read(Long id) {
        Author author = repository.findById(id).orElseThrow();
        return AuthorDto.fromEntity(author);
    }

    /*public AuthorDto update(Long id, AuthorDto dto) {
        Author author = repository.findById(id).orElseThrow();
        author.setName(dto.getName());
        author.setDebutYear(dto.getDebutYear());
        return AuthorDto.fromEntity(repository.save(author));
    }

    public void delete(Long id) {
        repository.delete(repository.findById(id).orElseThrow());
    }*/
}
