package com.example.todo.controllers;

import com.example.todo.entities.TodoGroup;
import com.example.todo.entities.TodoItem;
import com.example.todo.exceptions.cases.AuthorNotFoundException;
import com.example.todo.exceptions.cases.TodoGroupNotFoundException;
import com.example.todo.modelAssembler.TodoGroupModelAssembler;
import com.example.todo.modelAssembler.TodoItemModelAssembler;
import com.example.todo.repositories.TodoGroupRepository;
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
public class TodoGroupController {
    private  final TodoGroupRepository repository;
    private final TodoGroupModelAssembler assembler;

    TodoGroupController(TodoGroupRepository repository, TodoGroupModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/todoGroup")
    public CollectionModel<EntityModel<TodoGroup>> all() {

        List<EntityModel<TodoGroup>> todoGroups = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(todoGroups, linkTo(methodOn(AuthorController.class).all()).withSelfRel());
    }

    @PostMapping("/todoGroup")
    ResponseEntity<TodoGroup> newEntity(@RequestBody TodoGroup newTodoGroup) {
        EntityModel<TodoGroup> entityModel = assembler.toModel(repository.save(newTodoGroup));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    // Single item

    @GetMapping("/todoGroup/{id}")
    public EntityModel<TodoGroup> one(@PathVariable Long id) {
        TodoGroup todoItem = repository.findById(id) //
                .orElseThrow(() -> new TodoGroupNotFoundException(id));

        return assembler.toModel(todoItem);
    }

    @PutMapping("/todoGroup/{id}")
    ResponseEntity<TodoGroup> replaceAuthor(@RequestBody TodoGroup newTodoGroup, @PathVariable Long id) {

        TodoGroup updatedTodoItem = repository.findById(id)
                .map(todo -> {
                    todo.setName(newTodoGroup.getName());
                    return repository.save(todo);
                })
                .orElseGet(() -> repository.save(newTodoGroup));

        EntityModel<TodoGroup> entityModel = assembler.toModel(updatedTodoItem);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    @DeleteMapping("/todoGroup/{id}")
    ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
