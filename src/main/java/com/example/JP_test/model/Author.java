package com.example.JP_test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="author")

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long author_id;

    @JsonIgnore
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Book> book;

    @Column(name = "name_author")
    private String name_author;

    public Author() {
    }

    public Long getAuthor_id() {
        return author_id;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_author) {
        this.name_author = name_author;
    }

    public Author(List<Book> book, String name_author) {
        this.book = book;
        this.name_author = name_author;
    }
}