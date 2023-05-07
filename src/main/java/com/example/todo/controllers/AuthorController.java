package com.example.todo.controllers;

import com.example.todo.entities.Author;
import com.example.todo.exceptions.cases.AuthorNotFoundException;
import com.example.todo.modelAssembler.AuthorModelAssembler;
import com.example.todo.repositories.AuthorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
public class AuthorController {
    private  final AuthorRepository repository;
    private final AuthorModelAssembler assembler;

    AuthorController(AuthorRepository repository, AuthorModelAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @GetMapping("/authors")
    public List<Author> all() {
        return repository.findAll();
    }
    @PostMapping("/authors")
    Author newAuthor(@RequestBody Author newAuthor) {
        repository.save(newAuthor);

        return newAuthor;
    }

    // Single item

    @GetMapping("/authors/{id}")
    public Author one(@PathVariable Long id) {
        return repository.findById(id) //
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    @PutMapping("/authors/{id}")
    Author replaceAuthor(@RequestBody Author newEmployee, @PathVariable Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    newEmployee.setId(id);
                    return repository.save(newEmployee);
                });
    }

    @DeleteMapping("/authors/{id}")
    void deleteAuthor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
