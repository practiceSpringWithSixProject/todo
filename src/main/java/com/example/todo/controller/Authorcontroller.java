package com.example.todo.controller;

import com.example.todo.dto.AuthorDto;
import com.example.todo.model.Author;
import com.example.todo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class Authorcontroller {

  private final AuthorService authorService;


  //회원가입
    /*
    post
    http://localhost:8080/author
    {
      "authorName": "soonwook",
      "age": 20,
      "gender": "남자"
    }
     */
  @PostMapping("/author")
  public Author createAuthor(@RequestBody AuthorDto authorDto) {
    return authorService.createAuthor(authorDto);
  }


  //회원 조회
  @GetMapping("/author/{authorId}")
  public Author getAuthorId(@PathVariable Long authorId) {
    return authorService.getAuthorId(authorId);
  }

  //회원 정보 업데이트
  @PutMapping("/author/{authorId}")
  public Author updateAuthor(@PathVariable Long authorId, @RequestBody AuthorDto authorDto) {
    return authorService.updateAuthor(authorId, authorDto);
  }

  @DeleteMapping("/author/{authorId}")
  public Long deleteAuthor(@PathVariable Long authorId) {
    return authorService.deleteAuthor(authorId);
  }
}
