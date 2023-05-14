package com.example.todo.service;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import java.util.List;

public interface BucketServiceInterface {

  Bucket createBucket(BucketDto bucketDto, Long authorId);

  List<Bucket> getAllBucketsByAuthorId(Long authorId);

  Bucket updateBucket(BucketDto bucketDto, Long bucketId);

  List<ToDoItem> getTodoItems(Long bucketId);

  Author getAuthorByBucketId(Long bucketId);


}
