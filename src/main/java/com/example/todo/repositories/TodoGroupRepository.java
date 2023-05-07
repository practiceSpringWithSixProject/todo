package com.example.todo.repositories;

import com.example.todo.entities.TodoGroup;
import com.example.todo.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoGroupRepository extends JpaRepository<TodoGroup, Long> {

}
