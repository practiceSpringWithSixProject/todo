package com.example.todo.controller;

import com.example.todo.dto.AuthorDto;
import com.example.todo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Authorcontroller {
    private final AuthorService authorService;

    @PostMapping("/author")
    public int createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }
}
