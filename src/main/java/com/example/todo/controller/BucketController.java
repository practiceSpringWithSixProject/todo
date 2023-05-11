package com.example.todo.controller;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Bucket;
import com.example.todo.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BucketController {

  private final BucketService bucketService;

  @PostMapping("/bucket/{authorId}")
  public Bucket createBucket(@RequestBody BucketDto bucketDto, @PathVariable Long authorId) {
    return bucketService.createBucket(bucketDto, authorId);
  }


}
