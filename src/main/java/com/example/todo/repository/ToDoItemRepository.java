package com.example.todo.repository;

import com.example.todo.model.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem,Long> {
}
