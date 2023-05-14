package com.example.todo.controller;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import com.example.todo.response.ResponseEntity;
import com.example.todo.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

  private final ToDoItemService itemService;

  @PostMapping("/items/{authorId}")
  public ResponseEntity<ToDoItem> createItem(@RequestBody ToDoItemDto requestDto,
      @PathVariable Long authorId) {
    try {
      ToDoItem newItem = itemService.createItem(requestDto, authorId);
      return ResponseEntity.success(newItem);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/items")
  public ResponseEntity<ToDoItem> readOneItem(@RequestParam(value = "itemId") Long itemId) {
    try {
      ToDoItem foundItem = itemService.readItem(itemId);
      return ResponseEntity.success(foundItem);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/items/all/{authorId}")
  public ResponseEntity<List<ToDoItem>> readItemsByAuthorId(@PathVariable Long authorId) {
    try {
      List<ToDoItem> foundItems = itemService.readItemsByAuthorId(authorId);
      return ResponseEntity.success(foundItems);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/items/{itemId}")
  public ResponseEntity<ToDoItem> updateItem(@PathVariable Long itemId,
      @RequestParam(value = "bucketId", required = false) Long bucketId,
      @RequestBody(required = false) ToDoItemDto dto) {
    try {
      ToDoItem updatedItem = itemService.updateTodoItem(dto, itemId, bucketId);
      return ResponseEntity.success(updatedItem);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }
}
