package com.example.todo.exceptions.types;

import com.example.todo.exceptions.cases.AuthorNotFoundException;
import com.example.todo.exceptions.cases.TodoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundAdvice {
    @ResponseBody
    @ExceptionHandler({AuthorNotFoundException.class, TodoNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String DefaultNotFoundHandler(AuthorNotFoundException ex) {
        return ex.getMessage();
    }


}
