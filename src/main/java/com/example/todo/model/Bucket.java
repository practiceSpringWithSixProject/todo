package com.example.todo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

//@Entity
//@Getter
//@RequiredArgsConstructor
//public class Bucket extends Timestamped{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int bucketId;
//
//    @ManyToOne
//    @JoinColumn(name="author_id")
//    private Author author;
//
//    @OneToMany
//    @JoinColumn(name= "item_id")
//    private List<ToDoItem> toDoItems;
//}

@Entity
@Getter
@RequiredArgsConstructor
public class Bucket extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bucketId;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany
    @JoinColumn(name= "bucket_id") // 일치되는 논리적 열 이름으로 수정
    private List<ToDoItem> toDoItems;
}