package com.example.todo.dto;

import com.example.todo.model.Author;
import com.example.todo.model.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@Getter
@RequiredArgsConstructor
public class AuthorDto {
    private String authorName;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    public Author createAuthor(){
        return Author.builder()
                .authorName(authorName)
                .age(age)
                .gender(gender)
                .build();
    }
}