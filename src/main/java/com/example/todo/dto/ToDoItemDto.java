package com.example.todo.dto;

import com.example.todo.model.Author;
import com.example.todo.model.Priority;
import com.example.todo.model.ToDoItem;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Setter
@Getter
public class ToDoItemDto {

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Priority priorityEnum;

    private LocalDateTime deadline;

    public ToDoItem dtoToEntity(ToDoItemDto dto, Author author){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setTitle(dto.getTitle());
        toDoItem.setContent(dto.getContent());
        toDoItem.setPriorityEnum(dto.getPriorityEnum());
        toDoItem.setDeadline(dto.getDeadline());
        toDoItem.setCompleted(false);
        toDoItem.setAuthor(author);
        return toDoItem;
    }
}
