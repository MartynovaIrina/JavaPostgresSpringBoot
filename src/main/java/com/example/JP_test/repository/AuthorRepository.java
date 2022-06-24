package com.example.JP_test.repository;

import com.example.JP_test.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository <Author, Long> {
    @Query("select a from Author a where a.name_author = ?1")
    Optional<Author> getAuthorByName_author(String name_author);
}
