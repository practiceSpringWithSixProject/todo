package com.example.todo.controllers;

import com.example.todo.entities.Author;
import com.example.todo.entities.TodoItem;
import com.example.todo.exceptions.cases.AuthorNotFoundException;
import com.example.todo.modelAssembler.AuthorModelAssembler;
import com.example.todo.modelAssembler.TodoItemModelAssembler;
import com.example.todo.repositories.AuthorRepository;
import com.example.todo.repositories.TodoItemRepository;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class TodoItemController {
    private  final TodoItemRepository repository;
    private final TodoItemModelAssembler assembler;

    TodoItemController(TodoItemRepository repository, TodoItemModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/todoItem")
    public CollectionModel<EntityModel<TodoItem>> all() {

        List<EntityModel<TodoItem>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(AuthorController.class).all()).withSelfRel());
    }

    @PostMapping("/todoItem")
    ResponseEntity<TodoItem> newEntity(@RequestBody TodoItem newTodoItem) {
        EntityModel<TodoItem> entityModel = assembler.toModel(repository.save(newTodoItem));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    // Single item

    @GetMapping("/todoItem/{id}")
    public EntityModel<TodoItem> one(@PathVariable Long id) {
        TodoItem todoItem = repository.findById(id) //
                .orElseThrow(() -> new AuthorNotFoundException(id));

        return assembler.toModel(todoItem);
    }

    @PutMapping("/todoItem/{id}")
    ResponseEntity<TodoItem> replaceAuthor(@RequestBody TodoItem newTodoItem, @PathVariable Long id) {

        TodoItem updatedTodoItem = repository.findById(id)
                .map(todo -> {
                    todo.setPriority(newTodoItem.getPriority());
                    todo.setTitle(newTodoItem.getTitle());
                    todo.setContent(newTodoItem.getContent());
                    todo.setAuthor(newTodoItem.getAuthor());
                    todo.setDueDate(newTodoItem.getDueDate());
                    return repository.save(todo);
                })
                .orElseGet(() -> repository.save(newTodoItem));

        EntityModel<TodoItem> entityModel = assembler.toModel(updatedTodoItem);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    @DeleteMapping("/todoItem/{id}")
    ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
