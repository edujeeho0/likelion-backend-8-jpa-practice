package com.example.jpapractice.book.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;
    @Setter
    private Integer debutYear;

    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public Author(String name, Integer debutYear) {
        this.name = name;
        this.debutYear = debutYear;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", debutYear=" + debutYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(debutYear, author.debutYear);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, debutYear);
    }
}
