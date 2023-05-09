package com.example.todo.service;

import com.example.todo.dto.AuthorDto;
import com.example.todo.model.Author;
import com.example.todo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public int createAuthor(AuthorDto authorDto){
        Author newAuthor = authorDto.createAuthor();
        return authorRepository.save(newAuthor).getAuthorId();
    }
}
