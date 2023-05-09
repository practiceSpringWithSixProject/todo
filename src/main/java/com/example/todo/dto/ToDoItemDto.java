package com.example.todo.dto;

import com.example.todo.model.Author;
import com.example.todo.model.Priority;
import com.example.todo.model.ToDoItem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ToDoItemDto {

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Priority priorityEnum;

    private Author author;


    public ToDoItem createToDoItem() {
        return ToDoItem.builder()
                .title(title)
                .content(content)
                .priority(priorityEnum)
                .author(author)
                .build();
    }
}
