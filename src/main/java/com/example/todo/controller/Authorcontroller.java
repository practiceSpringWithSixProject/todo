package com.example.todo.controller;

import com.example.todo.dto.AuthorDto;
import com.example.todo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Authorcontroller {
    private final AuthorService authorService;


    //회원가입
    @PostMapping("/author")
    public Long createAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.createAuthor(authorDto);
    }


    //회원 조회
    @GetMapping("/author/{authorId}")
    public Long getAuthorId(@PathVariable Long authorId){
        return authorService.getAuthorId(authorId);

    }
}
