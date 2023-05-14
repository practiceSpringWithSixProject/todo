package com.example.todo.controller;

import com.example.todo.dto.AuthorDto;
import com.example.todo.model.Author;
import com.example.todo.response.ResponseEntity;
import com.example.todo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Authorcontroller {

  private final AuthorService authorService;

  @PostMapping("/author")
  public ResponseEntity<Author> createAuthor(@RequestBody AuthorDto authorDto) {
    try {
      Author newAuthor = authorService.createAuthor(authorDto);
      return ResponseEntity.success(newAuthor);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  //회원 조회
  @GetMapping("/author/{authorId}")
  public ResponseEntity<Author> getAuthorId(@PathVariable Long authorId) {
    try {
      Author foundAuthor = authorService.getAuthorId(authorId);
      return ResponseEntity.success(foundAuthor);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  //회원 정보 업데이트
  @PutMapping("/author/{authorId}")
  public ResponseEntity<Author> updateAuthor(@PathVariable Long authorId,
      @RequestBody AuthorDto authorDto) {
    try {
      Author updatedAuthor = authorService.updateAuthor(authorId, authorDto);
      return ResponseEntity.success(updatedAuthor);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }

  @DeleteMapping("/author/{authorId}")
  public ResponseEntity<Long> deleteAuthor(@PathVariable Long authorId) {
    try {
      Long deletedAuthorId = authorService.deleteAuthor(authorId);
      return ResponseEntity.success(deletedAuthorId);
    } catch (Exception e) {
      return ResponseEntity.fail(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }
  }
}
