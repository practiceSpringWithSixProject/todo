package com.example.todo.exceptions.cases;

public class TodoGroupNotFoundException extends RuntimeException {
    public TodoGroupNotFoundException(Long id) {
        super("Could not find group " + id);
    }
}
