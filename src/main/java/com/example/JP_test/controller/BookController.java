package com.example.JP_test.controller;

import com.example.JP_test.model.Author;
import com.example.JP_test.model.Book;
import com.example.JP_test.model.Genre;
import com.example.JP_test.repository.AuthorRepository;
import com.example.JP_test.repository.BookRepository;
import com.example.JP_test.repository.GenreRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    GenreRepository genreRepository;

    @GetMapping
    public ResponseEntity getAllBooks(){
        return ResponseEntity.ok(this.bookRepository.findAll());
    }

    @PostMapping("/addbook")
    public ResponseEntity createbook(@RequestBody @NotNull ObjectNode json) {
        Author author = new Author();
        Genre genre = new Genre();

        Optional<Author> authorOptional =
                authorRepository.getAuthorByName_author(json.get("author").textValue());

        if(authorOptional.isPresent()) {
            author = authorOptional.get();
        }
        else{
            author.setName_author(json.get("author").textValue());
            authorRepository.save(author);
        }

        String curr_genre_name = json.get("genre").textValue();
        Optional<Genre> genreOptional =
                genreRepository.getGenreByName_genre(curr_genre_name);

        if(genreOptional.isPresent()) {
            genre = genreOptional.get();
        }
        else {
            genre.setName_genre(curr_genre_name);
            genreRepository.save(genre);
        }

        Book book = new Book();
        book.setTitle(json.get("title").textValue());
        book.setAuthor(author);
        book.setPrice(json.get("price").asDouble());
        book.setAmount(json.get("amount").asInt());
        book.setGenre(genre);
        bookRepository.save(book);
        return  ResponseEntity.ok("ok");
    }
/*
    @DeleteMapping("{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        Book book = this.bookRepository.findById(id).get();
        this.bookRepository.deleteById(id);
        return ResponseEntity.ok(book);
    }
    */

    //delete by author ID
    @DeleteMapping("{id}")
    public ResponseEntity deleteBookbyAuthorId(@PathVariable Long id){
        Author author = this.authorRepository.findById(id).get();
        this.authorRepository.deleteById(id);
        return  ResponseEntity.ok(author);
    }

}
