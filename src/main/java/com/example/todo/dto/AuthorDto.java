package com.example.todo.dto;

import com.example.todo.model.Author;
import com.example.todo.model.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private String authorName;
    private int age;
    private Gender gender;


    public Author createAuthor(){
        return Author.builder()
                .authorName(authorName)
                .age(age)
                .gender(gender)
                .build();
    }
}