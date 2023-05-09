package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;

import java.util.List;

public interface ToDoInterface {

    //CREATE METHODS
    ToDoItemDto createItem(ToDoItemDto doItemDto);


    //READ METHODS
    ToDoItemDto readItem(int itemId);

    List<ToDoItem> readAllItem(int authorId);

    List<ToDoItem> readItemByBucket(ToDoItemDto doItemDto);

    //UPDATE METHODS


    //DELETE METHODS

}
