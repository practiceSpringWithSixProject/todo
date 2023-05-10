package com.example.todo.dto;

import com.example.todo.model.Author;
import com.example.todo.model.Priority;
import com.example.todo.model.ToDoItem;
import com.example.todo.service.ToDoItemService;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.util.Date;

@Data
@AllArgsConstructor
@Setter
public class ToDoItemDto {

    private String title;

    private String content;

    @Enumerated(EnumType.STRING)
    private Priority priorityEnum;

    private Date deadline;

    @Builder
    public ToDoItem dtoToEntity(ToDoItemDto dto){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setTitle(dto.title);
        toDoItem.setContent(dto.content);
        toDoItem.setPriorityEnum(dto.priorityEnum);
        toDoItem.setDeadline(dto.deadline);
        toDoItem.setCompleted(false);
        return toDoItem;
    }
}
