package com.example.todo.model;


import jakarta.persistence.*;
import lombok.Getter;
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

    @OneToMany(mappedBy = "bucket")
    private List<ToDoItem> toDoItems;
}
