package com.example.todo.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

//@Entity
//@Getter
//@RequiredArgsConstructor
//public class ToDoItem extends Timestamped{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int itemId;
//
//    @Column
//    private String title;
//
//    @Column
//    private String content;
//
//    @Column
//    @Enumerated(EnumType.STRING)
//    private Priority priorityEnum;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
//    private Author author;
//
//
//    @Builder
//    public ToDoItem(String title, String content, Priority priority) {
//        this.title = title;
//        this.content = content;
//        this.priorityEnum = priority;
//    }
//
//}

@Entity
@Getter
@RequiredArgsConstructor
public class ToDoItem extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id") // 논리적 열 이름 수정
    private int itemId;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    @Enumerated(EnumType.STRING)
    private Priority priorityEnum;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;


    @Builder
    public ToDoItem(String title, String content, Priority priority, Author author) {
        this.title = title;
        this.content = content;
        this.priorityEnum = priority;
        this.author = author;
    }

}
