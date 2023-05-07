package com.example.todo.dtos.requests;
import java.time.LocalDateTime;
import java.util.Optional;

public record TodoItemRequestDTO(
        Optional<String> title,
        Optional<String> content,
        Optional<String> priority,
        Optional<LocalDateTime> dueDate,
        Optional<Long> authorId,
        Optional<Long> todoGroupId
) {
}

