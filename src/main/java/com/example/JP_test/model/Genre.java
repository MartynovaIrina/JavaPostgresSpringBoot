package com.example.JP_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genre")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genre_id;
    private String name_genre;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> books;

    public Genre() {
    }

    public Genre(String name_genre, List<Book> books) {
        this.name_genre = name_genre;
        this.books = books;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public String getName_genre() {
        return name_genre;
    }

    public void setName_genre(String name_genre) {
        this.name_genre = name_genre;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
