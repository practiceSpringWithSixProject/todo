package com.example.todo.model;

import com.example.todo.dto.ToDoItemDto;
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


  public void update(ToDoItemDto dto, Bucket bucket) {
    if(dto.getTitle()!=null && !dto.getTitle().isBlank() && !dto.getTitle().isEmpty()){
      this.title = dto.getTitle();
    }
    if(dto.getContent()!=null && !dto.getContent().isBlank() && !dto.getContent().isEmpty()){
      this.content = dto.getContent();
    }
    if(dto.getPriorityEnum()!=null){
      this.priorityEnum = dto.getPriorityEnum();
    }
    if(dto.getDeadline()!=null && !dto.getDeadline().toString().isBlank() && !dto.getDeadline().toString().isEmpty()){
      this.deadline = dto.getDeadline();
    }
    this.isCompleted = dto.isComplete();
    this.bucket = bucket;
  }
  public void update(Bucket bucket) {
    this.bucket = bucket;
  }
}
