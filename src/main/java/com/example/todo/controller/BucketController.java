package com.example.todo.controller;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import com.example.todo.response.ResponseEntity;
import com.example.todo.service.BucketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BucketController {

  private final BucketService bucketService;

  @PostMapping("/bucket/{authorId}")
  public ResponseEntity<Bucket> createBucket(@RequestBody BucketDto bucketDto,
      @PathVariable Long authorId) {
    try {
      Bucket newBucket = bucketService.createBucket(bucketDto, authorId);
      return ResponseEntity.success(newBucket);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/bucket/owner/{authorId}")
  public ResponseEntity<List<Bucket>> getBucketsByAuthorId(@PathVariable Long authorId) {
    try {
      List<Bucket> foundList = bucketService.getAllBucketsByAuthorId(authorId);
      return ResponseEntity.success(foundList);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/bucket/{bucketId}")
  public ResponseEntity<List<ToDoItem>> getAllToDoItemsByBucketId(@PathVariable Long bucketId) {
    try {
      List<ToDoItem> foundItems = bucketService.getTodoItems(bucketId);
      return ResponseEntity.success(foundItems);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @GetMapping("/bucket")
  public ResponseEntity<Author> getAuthorByBucketId(
      @RequestParam(value = "bucketId") Long bucketId) {
    try {
      Author foundAuthor = bucketService.getAuthorByBucketId(bucketId);
      return ResponseEntity.success(foundAuthor);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

  @PutMapping("/bucket/{bucketId}")
  public ResponseEntity<Bucket> updateBucket(@RequestBody BucketDto bucketDto,
      @PathVariable Long bucketId) {
    try {
      Bucket updatedBucket = bucketService.updateBucket(bucketDto, bucketId);
      return ResponseEntity.success(updatedBucket);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }

}
