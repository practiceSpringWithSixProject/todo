package com.example.todo.controller;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import com.example.todo.service.BucketService;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
  public Bucket createBucket(@RequestBody BucketDto bucketDto, @PathVariable Long authorId) {
    return bucketService.createBucket(bucketDto, authorId);
  }

  @GetMapping("/bucket/{authorId}")
  public List<Bucket> getBucketsByAuthorId(@PathVariable Long authorId) {
    return bucketService.getAllBucketsByAuthorId(authorId);
  }

  @GetMapping("/bucket/{bucketId}")
  public List<ToDoItem> getAllToDoItemsByBucketId(@PathVariable Long bucketId) {
    return bucketService.getTodoItems(bucketId);
  }

  @GetMapping("/bucket")
  public Author getAuthorByBucketId(@RequestParam(value = "bucketId") Long bucketId) {
    return bucketService.getAuthorByBucketId(bucketId);
  }

  @PutMapping("/bucket/{bucketId}")
  public Bucket updateBucket(@RequestBody BucketDto bucketDto, @PathVariable Long bucketId) {
    return bucketService.updateBucket(bucketDto, bucketId);
  }


}
