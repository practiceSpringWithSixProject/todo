package com.example.todo.service;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.ToDoItem;

import java.util.List;

public interface BucketServiceInterface {

  Long createBucket(BucketDto bucketDto, Long authorId);

  Long getBucket(Long bucketId);

  Long updateBucket(BucketDto bucketDto, Long bucketId);

  List<ToDoItem> getTodoItems(Long bucketId);

  String getAuthorNameByBucketId(Long bucketId);


}
