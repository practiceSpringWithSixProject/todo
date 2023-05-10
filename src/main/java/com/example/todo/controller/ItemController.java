package com.example.todo.controller;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;
import com.example.todo.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ToDoItemService itemService;

    @PostMapping("/items/{authorId}")
    public Long createItem(@RequestBody ToDoItemDto requestDto, @PathVariable Long authorId){
        return itemService.createItem(requestDto,authorId);
    }

    @GetMapping("/items/read")
    public Long readOneItem(@RequestParam(value="itemId") Long itemId){
        return itemService.readItem(itemId);

    }
}
