package com.example.todo.controller;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;
import com.example.todo.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/todo")
@RequiredArgsConstructor
public class ItemController {

    private final ToDoItemService itemService;


    @GetMapping("/items")
    public List<ToDoItem> readAllMyItems(@RequestParam(value="author") int authorId){
        return itemService.readAllItem(authorId);

    }

    @GetMapping("/items/read")
    public ToDoItemDto readOneItem(@RequestParam(value="itemId") int itemId){
        return itemService.readItem(itemId);

    }

    @PostMapping("/items")
    public ToDoItemDto createItem(@RequestBody ToDoItemDto itemDto){

        return itemService.createItem(itemDto);
    }
}
