package com.example.todo.exceptions.cases;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(Long id) {
        super("Could not find author " + id);
    }
}
