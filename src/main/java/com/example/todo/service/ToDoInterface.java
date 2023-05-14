package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;

import java.util.List;

public interface ToDoInterface {

  //CREATE METHODS
  ToDoItem createItem(ToDoItemDto doItemDto, Long userId);


  //READ METHODS
  ToDoItem readItem(Long itemId);

  List<ToDoItem> readItemsByAuthorId(Long authorId);

  //UPDATE METHODS
  ToDoItem updateTodoItem(ToDoItemDto dto, Long itemId, Long bucketId);
  //DELETE METHODS

}
