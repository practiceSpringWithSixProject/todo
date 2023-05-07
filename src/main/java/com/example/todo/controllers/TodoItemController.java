package com.example.todo.controllers;

import com.example.todo.dtos.requests.TodoItemRequestDTO;
import com.example.todo.entities.TodoItem;
import com.example.todo.exceptions.cases.TodoNotFoundException;
import com.example.todo.modelAssembler.TodoItemModelAssembler;
import com.example.todo.services.TodoItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class TodoItemController {
    private final TodoItemModelAssembler assembler;
    private final TodoItemService service;

    TodoItemController(TodoItemService service, TodoItemModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @GetMapping("/todoItem")
    public List<TodoItem> all() {

        return service.list();
    }

    @PostMapping("/todoItem")
    TodoItem newEntity(@RequestBody TodoItemRequestDTO newTodoItem) {
        TodoItem createdEntity = service.create(newTodoItem);

        return createdEntity;
    }

    // Single item

    @GetMapping("/todoItem/{id}")
    public TodoItem one(@PathVariable Long id) {
        return service.detail(id) //
                .orElseThrow(() -> new TodoNotFoundException(id));
    }

    @PutMapping("/todoItem/{id}")
    TodoItem replaceTodoItem(@RequestBody TodoItemRequestDTO newTodoItem, @PathVariable Long id) {

        return service.upsertById(id, newTodoItem);
    }

    @DeleteMapping("/todoItem/{id}")
    void deleteTodoItem(@PathVariable Long id) {
        service.deleteById(id);
    }
}
