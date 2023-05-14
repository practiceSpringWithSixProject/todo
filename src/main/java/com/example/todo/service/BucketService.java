package com.example.todo.service;

import com.example.todo.dto.BucketDto;
import com.example.todo.model.Author;
import com.example.todo.model.Bucket;
import com.example.todo.model.ToDoItem;
import com.example.todo.repository.AuthorRepository;
import com.example.todo.repository.BucketRepository;
import com.example.todo.repository.ToDoItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BucketService implements BucketServiceInterface {

  private final BucketRepository bucketRepository;
  private final AuthorRepository authorRepository;
  private final ToDoItemRepository toDoItemRepository;

  @Override
  public Bucket createBucket(BucketDto bucketDto, Long authorId) {
    Author found = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));

    Bucket bucket = bucketDto.builder()
        .bucketName(bucketDto.getBucketName())
        .author(found)
        .build();

    return bucketRepository.save(bucket);
  }

  @Override
  public List<Bucket> getAllBucketsByAuthorId(Long authorId) {
    return bucketRepository.findAllByAuthor_Id(authorId)
        .orElseThrow(() -> new IllegalArgumentException("회원 정보가 존재하지 않습니다"));
  }

  @Override
  public Bucket updateBucket(BucketDto bucketDto, Long bucketId) {
    Bucket found = bucketRepository.findById(bucketId)
        .orElseThrow(() -> new IllegalArgumentException("해당 버켓이 존재하지 않습니다"));

    if (!bucketDto.getBucketName().isBlank() && !bucketDto.getBucketName().isEmpty()) {
      found.setBucketName(bucketDto.getBucketName());
    }

    return found;
  }

  @Override
  public List<ToDoItem> getTodoItems(Long bucketId) {
    return toDoItemRepository.findAllByBucket_Id(bucketId)
        .orElseThrow(() -> new IllegalArgumentException("해당 버팃이 존재하지 않습니다."));
  }

  @Override
  public String getAuthorNameByBucketId(Long bucketId) {
    return null;
  }
}
