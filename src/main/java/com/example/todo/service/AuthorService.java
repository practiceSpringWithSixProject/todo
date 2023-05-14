package com.example.todo.service;

import com.example.todo.dto.AuthorDto;
import com.example.todo.model.Author;
import com.example.todo.model.Gender;
import com.example.todo.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthorService {

  private final AuthorRepository authorRepository;

  public Author createAuthor(AuthorDto authorDto) {
    Author newAuthor = authorDto.createAuthor();
    return authorRepository.save(newAuthor);
  }

  public Author getAuthorId(Long authorId) {
    return authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));
  }

  public Author updateAuthor(Long authorId, AuthorDto authorDto) {
    Author author = authorRepository.findById(authorId)
        .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다"));
    String updatedAuthorName = authorDto.getAuthorName();
    int updatedAge = authorDto.getAge();
    Gender updatedGender = authorDto.getGender();
    if (!updatedAuthorName.isEmpty() && !updatedAuthorName.isBlank()) {
      author.setAuthorName(authorDto.getAuthorName());
    }
    if (!Integer.toString(updatedAge).isEmpty() && !Integer.toString(updatedAge).isBlank()) {
      author.setAge(authorDto.getAge());
    }
    if (!updatedGender.equals(author.getGender())) {
      author.setGender(authorDto.getGender());
    }
    return author;
  }

  public Long deleteAuthor(Long authorId) {
    authorRepository.deleteById(authorId);
    return authorId;
  }
}
