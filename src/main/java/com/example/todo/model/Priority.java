package com.example.todo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Priority {
  HIGH("중요"),

  MIDDLE("중간"),

  LOW("후순위");

  private final String priority;


}
