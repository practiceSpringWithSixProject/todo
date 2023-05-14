package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
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
public class ToDoItemService implements ToDoInterface {

  private final ToDoItemRepository doItemRepository;
  private final AuthorRepository authorRepository;

  private final BucketRepository bucketRepository;


  // CREATE METHOD
  @Override
  public ToDoItem createItem(ToDoItemDto doItemDto, Long userId) {
    Author foundAuthor = authorRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("회원정보가 없습니다"));

    ToDoItem newItem = doItemDto.dtoToEntity(doItemDto, foundAuthor);

    return doItemRepository.save(newItem);
  }

  // READ METHOD
  @Override
  public ToDoItem readItem(Long itemId) {
    return doItemRepository.findById(itemId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
  }

  @Override
  public List<ToDoItem> readItemsByAuthorId(Long authorId) {
    return doItemRepository.findAllByAuthor_Id(authorId).orElseThrow();
  }

  //UPDATE METHOD
  @Override
  public ToDoItem updateTodoItem(ToDoItemDto dto, Long itemId, Long bucketId) {
    ToDoItem foundItem = doItemRepository.findById(itemId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다"));
    Bucket foundBucket = bucketRepository.findById(bucketId).orElse(null);
    if (dto != null) {
      foundItem.update(dto, foundBucket);
    } else {
      foundItem.update(foundBucket);
    }
    return foundItem;
  }
}
