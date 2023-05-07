package com.example.todo.exceptions.cases;

public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(Long id)  {
        super("Could not find the todo you requested " + id);
    }
}
