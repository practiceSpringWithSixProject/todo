package com.example.todo.repository;

import com.example.todo.model.Author;
import com.example.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoItemRepository extends JpaRepository<ToDoItem,Integer> {

    Optional<ToDoItem> findByItemId(Integer id);
    Optional<ToDoItem> findByTitle(String title);
    List<ToDoItem> findByAuthor_AuthorId(int authorId);
}
