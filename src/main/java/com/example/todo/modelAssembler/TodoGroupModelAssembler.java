package com.example.todo.modelAssembler;

import com.example.todo.controllers.TodoGroupController;
import com.example.todo.controllers.TodoItemController;
import com.example.todo.entities.TodoGroup;
import com.example.todo.entities.TodoItem;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class TodoGroupModelAssembler implements RepresentationModelAssembler<TodoGroup , EntityModel<TodoGroup >> {

    @Override
    public EntityModel<TodoGroup> toModel(TodoGroup entity) {
        return EntityModel.of(entity, //
                linkTo(methodOn(TodoGroupController.class).one(entity.getId())).withSelfRel(),
                linkTo(methodOn(TodoGroupController.class).all()).withRel("todoGroup"));
    }
}
