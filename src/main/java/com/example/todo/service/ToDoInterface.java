package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;

import java.util.List;

public interface ToDoInterface {

  //CREATE METHODS
  Long createItem(ToDoItemDto doItemDto, Long userId);


  //READ METHODS
  Long readItem(Long itemId);

  List<ToDoItem> readItemsByAuthorId(Long authorId);

  //UPDATE METHODS
  ToDoItem updateTodoItem(ToDoItemDto dto, Long itemId, Long bucketId);
  //DELETE METHODS

}
