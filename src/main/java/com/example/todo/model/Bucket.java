package com.example.todo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Table(name = "buckets")
@Getter
@Setter
@RequiredArgsConstructor
public class Bucket extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @OneToMany(mappedBy = "bucket")// 일치되는 논리적 열 이름으로 수정
    private List<ToDoItem> toDoItems;
}
