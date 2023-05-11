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
  public Long createItem(@RequestBody ToDoItemDto requestDto, @PathVariable Long authorId) {
    return itemService.createItem(requestDto, authorId);
  }

  @GetMapping("/items")
  public Long readOneItem(@RequestParam(value = "itemId") Long itemId) {
    return itemService.readItem(itemId);
  }

  @GetMapping("/items/all/{authorId}")
  public List<ToDoItem> readItemsByAuthorId(@PathVariable Long authorId) {
    return itemService.readItemsByAuthorId(authorId);
  }
}
