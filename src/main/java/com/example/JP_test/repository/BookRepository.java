package com.example.JP_test.repository;

import com.example.JP_test.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BookRepository extends JpaRepository <Book, Long> {
}
