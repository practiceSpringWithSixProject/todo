package com.example.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE("남자"),
    FEMALE("여자"),
    ETC("기타");

    private final String gender;
}
