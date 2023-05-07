package com.example.todo.controllers;

import com.example.todo.entities.Author;
import com.example.todo.exceptions.cases.AuthorNotFoundException;
import com.example.todo.modelAssembler.AuthorModelAssembler;
import com.example.todo.repositories.AuthorRepository;
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
public class AuthorController {
    private  final AuthorRepository repository;
    private final AuthorModelAssembler assembler;

    AuthorController(AuthorRepository repository, AuthorModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/authors")
    public CollectionModel<EntityModel<Author>> all() {

        List<EntityModel<Author>> employees = repository.findAll().stream() //
                .map(assembler::toModel) //
                .collect(Collectors.toList());

        return CollectionModel.of(employees, linkTo(methodOn(AuthorController.class).all()).withSelfRel());
    }
    @PostMapping("/authors")
    ResponseEntity<Author> newAuthor(@RequestBody Author newEmployee) {
        EntityModel<Author> entityModel = assembler.toModel(repository.save(newEmployee));

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    // Single item

    @GetMapping("/authors/{id}")
    public EntityModel<Author> one(@PathVariable Long id) {
        Author author = repository.findById(id) //
                .orElseThrow(() -> new AuthorNotFoundException(id));

        return assembler.toModel(author);
    }

    @PutMapping("/authors/{id}")
    ResponseEntity<Author> replaceAuthor(@RequestBody Author newEmployee, @PathVariable Long id) {

        Author updatedAuthor = repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });

        EntityModel<Author> entityModel = assembler.toModel(updatedAuthor);

        return ResponseEntity //
                .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
                .body(entityModel.getContent());
    }

    @DeleteMapping("/authors/{id}")
    ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
