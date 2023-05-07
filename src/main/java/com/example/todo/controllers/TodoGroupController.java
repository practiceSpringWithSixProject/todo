package com.example.todo.controllers;

import com.example.todo.entities.TodoGroup;
import com.example.todo.exceptions.cases.TodoGroupNotFoundException;
import com.example.todo.modelAssembler.TodoGroupModelAssembler;
import com.example.todo.repositories.TodoGroupRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class TodoGroupController {
    private  final TodoGroupRepository repository;
    private final TodoGroupModelAssembler assembler;

    TodoGroupController(TodoGroupRepository repository, TodoGroupModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/todoGroup")
    public List<TodoGroup> all() {

        return repository.findAll();
    }

    @PostMapping("/todoGroup")
    TodoGroup newEntity(@RequestBody TodoGroup newTodoGroup) {
        return repository.save(newTodoGroup);
    }

    // Single item

    @GetMapping("/todoGroup/{id}")
    public TodoGroup one(@PathVariable Long id) {
        return repository.findById(id) //
                .orElseThrow(() -> new TodoGroupNotFoundException(id));
    }

    @PutMapping("/todoGroup/{id}")
    TodoGroup replaceAuthor(@RequestBody TodoGroup newTodoGroup, @PathVariable Long id) {

        return repository.findById(id)
                .map(todo -> {
                    todo.setName(newTodoGroup.getName());
                    return repository.save(todo);
                })
                .orElseGet(() -> repository.save(newTodoGroup));
    }

    @DeleteMapping("/todoGroup/{id}")
    void deleteTodoItem(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
