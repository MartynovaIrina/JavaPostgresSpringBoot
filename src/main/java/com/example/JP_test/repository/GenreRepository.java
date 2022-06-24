package com.example.JP_test.repository;

import com.example.JP_test.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    @Query("select g from Genre g where g.name_genre = ?1")
    Optional<Genre> getGenreByName_genre(String name_genre);
}
