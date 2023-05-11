package com.example.todo.controller;

import com.example.todo.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BucketController {

  private final BucketService bucketService;


}
