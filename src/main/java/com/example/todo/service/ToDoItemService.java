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
public class ToDoItemService implements ToDoInterface{

    private final ToDoItemRepository doItemRepository;

    private final AuthorRepository authorRepository;


    // CREATE METHOD
    @Override
    public ToDoItemDto createItem(ToDoItemDto doItemDto) {
        ToDoItem found = doItemRepository.findByTitle(doItemDto.getTitle()).orElse(null);
        if(found==null) {
            found = doItemDto.createToDoItem();
            doItemRepository.save(found);
        }else{
            throw new IllegalArgumentException("이미 존재하는 목록입니다");
        }
        return doItemDto;
    }

    // READ METHOD
    @Override
    public ToDoItemDto readItem(int itemId) {
        ToDoItem found = doItemRepository.findByItemId(itemId).orElseThrow(
                ()-> new IllegalArgumentException("존재하지 않는 목록입니다."));

        ToDoItemDto responseDto =
                new ToDoItemDto(found.getTitle(), found.getContent(), found.getPriorityEnum(), found.getAuthor());
        return responseDto;
    }

    @Override
    public List<ToDoItem> readAllItem(int authorId) {
        Author foundAuthor = authorRepository.findByAuthorId(authorId).orElseThrow(
                ()-> new IllegalArgumentException("해당 작성자가 존재하지 않습니다.")
        );
        return doItemRepository.findByAuthor_AuthorId(authorId);
    }


    @Override
    public List<ToDoItem> readItemByBucket(ToDoItemDto doItemDto) {
        return null;
    }

    //UPDATE METHOD


}
