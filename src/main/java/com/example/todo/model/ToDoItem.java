package com.example.todo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "todo_items")
@Getter
@Setter
@RequiredArgsConstructor
public class ToDoItem extends Timestamped {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Long id;

  @Column
  private String title;

  @Column
  private String content;

  @Column
  @Enumerated(EnumType.STRING)
  private Priority priorityEnum;

  @Column
  private LocalDateTime deadline;

  @Column
  private boolean isCompleted;

  @ManyToOne
  @JoinColumn(name = "author_id")
  private Author author;

  @ManyToOne
  @JoinColumn(name = "bucket_id")
  private Bucket bucket;

}
