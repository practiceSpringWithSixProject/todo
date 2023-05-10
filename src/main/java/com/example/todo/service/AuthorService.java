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

    public Long createAuthor(AuthorDto authorDto){
        Author newAuthor = authorDto.createAuthor();
        return authorRepository.save(newAuthor).getId();
    }

    public Long getAuthorId(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(()->new IllegalArgumentException("존재하지 않는 회원입니다.")).getId();
    }
}
