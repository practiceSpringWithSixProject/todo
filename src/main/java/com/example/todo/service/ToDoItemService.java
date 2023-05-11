package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.Author;
import com.example.todo.model.ToDoItem;
import com.example.todo.repository.AuthorRepository;
import com.example.todo.repository.ToDoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoItemService implements ToDoInterface {

  private final ToDoItemRepository doItemRepository;

  private final AuthorRepository authorRepository;


  // CREATE METHOD
  @Override
  public Long createItem(ToDoItemDto doItemDto, Long userId) {
    Author foundAuthor = authorRepository.findById(userId)
        .orElseThrow(() -> new IllegalArgumentException("회원정보가 없습니다"));

    ToDoItem newItem = doItemDto.dtoToEntity(doItemDto, foundAuthor);
    System.out.println(newItem.toString());
    return doItemRepository.save(newItem).getId();
  }

  // READ METHOD
  @Override
  public Long readItem(Long itemId) {
    return doItemRepository.findById(itemId)
        .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다")).getId();
  }

  @Override
  public List<ToDoItem> readItemsByAuthorId(Long authorId) {
    return doItemRepository.findAllByAuthor_Id(authorId).orElseThrow();
  }

  //UPDATE METHOD


}
