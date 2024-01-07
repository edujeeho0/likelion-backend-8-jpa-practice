package com.example.jpapractice.book.dto;

import com.example.jpapractice.book.entity.Author;
import com.example.jpapractice.book.entity.Book;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    @Setter
    private String name;
    @Setter
    private Integer debutYear;
    @Setter
    private List<BookDto> books = new ArrayList<>();

    public AuthorDto(String name, Integer debutYear) {
        this.name = name;
        this.debutYear = debutYear;
    }

    public AuthorDto(Long id, String name, Integer debutYear) {
        this.id = id;
        this.name = name;
        this.debutYear = debutYear;
    }

    public static AuthorDto fromEntity(Author entity) {
        AuthorDto dto = new AuthorDto(
                entity.getId(),
                entity.getName(),
                entity.getDebutYear()
        );
        for (Book book: entity.getBooks()) {
            dto.books.add(BookDto.fromEntity(book, false));
        }
        return dto;
    }

}
