package com.example.todo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

//@Entity
//@RequiredArgsConstructor
//@Getter
//public class Author extends Timestamped{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int authorId;
//
//    @Column
//    private String authorName;
//
//    @Column
//    private int age;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private Gender gender;
//
//    @OneToMany
//    @JoinColumn(name="item_id")
//    private List<ToDoItem> items;
//}

@Entity
@Getter
@RequiredArgsConstructor

public class Author extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column // 논리적 열 이름 수정
    private String authorName;

    @Column
    private int age;

    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany
    @JoinColumn(name = "author_id") // 일치되는 논리적 열 이름으로 수정
    private List<ToDoItem> items;

    @Builder
    public Author(String authorName, int age, Gender gender) {
        this.authorName = authorName;
        this.age = age;
        this.gender = gender;
    }

}
