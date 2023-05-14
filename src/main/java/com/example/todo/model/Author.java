package com.example.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@RequiredArgsConstructor
public class Author extends Timestamped {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column // 논리적 열 이름 수정
  private String authorName;

  @Column
  private int age;

  @Column
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @OneToMany(mappedBy = "author", orphanRemoval=true)
  @JsonIgnore // jakarta의 json 순환 참조 방지
  private List<ToDoItem> items;

  @OneToMany(mappedBy = "author", orphanRemoval=true)
  @JsonIgnore
  private List<Bucket> buckets;

  @Builder
  public Author(String authorName, int age, Gender gender) {
    this.authorName = authorName;
    this.age = age;
    this.gender = gender;
  }

}
