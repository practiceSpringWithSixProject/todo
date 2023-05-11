package com.example.todo.repository;

import com.example.todo.model.Author;
import com.example.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

  @Query("SELECT t from ToDoItem t where t.author.id = :authorId")
  Optional<List<ToDoItem>> findAllByAuthor_Id(Long authorId);
}
