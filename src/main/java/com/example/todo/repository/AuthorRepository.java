package com.example.todo.repository;

import com.example.todo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Integer> {

    Optional<Author> findByAuthorId(Integer authorId);

}
