package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;

public interface ToDoInterface {

    //CREATE METHODS
    Long createItem(ToDoItemDto doItemDto, Long userId);



    //READ METHODS
    Long readItem(Long itemId);



    //UPDATE METHODS




    //DELETE METHODS

}
