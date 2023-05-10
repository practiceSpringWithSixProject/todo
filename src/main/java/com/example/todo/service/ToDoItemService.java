package com.example.todo.service;

import com.example.todo.dto.ToDoItemDto;
import com.example.todo.model.ToDoItem;
import com.example.todo.repository.AuthorRepository;
import com.example.todo.repository.ToDoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToDoItemService implements ToDoInterface{

    private final ToDoItemRepository doItemRepository;

    private final AuthorRepository authorRepository;


    // CREATE METHOD
    @Override
    public Long createItem(ToDoItemDto doItemDto,Long userId) {
        ToDoItem newItem = doItemDto.dtoToEntity(doItemDto);
        return doItemRepository.save(newItem).getId();
    }

    // READ METHOD
    @Override
    public Long readItem(Long itemId) {
        return doItemRepository.findById(itemId).orElseThrow(()->new IllegalArgumentException("게시글이 존재하지 않습니다")).getId();
    }
    //UPDATE METHOD


}
