package com.example.todo.services;
import com.example.todo.dtos.requests.TodoItemRequestDTO;
import com.example.todo.entities.TodoItem;
import com.example.todo.repositories.AuthorRepository;
import com.example.todo.repositories.TodoGroupRepository;
import com.example.todo.repositories.TodoItemRepository;
import com.example.todo.utils.constants.Priority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class TodoItemService {
    private final TodoItemRepository todoItemRepository;
    private final AuthorRepository authorRepository;
    private final TodoGroupRepository todoGroupRepository;

    public TodoItemService(
            TodoItemRepository todoItemRepository,
            AuthorRepository authorRepository,
            TodoGroupRepository todoGroupRepository
    ) {
        this.todoItemRepository = todoItemRepository;
        this.authorRepository = authorRepository;
        this.todoGroupRepository = todoGroupRepository;
    }

    public List<TodoItem> list() {

        return todoItemRepository.findAll();
    }

    public Optional<TodoItem> detail(Long id) {
        return todoItemRepository.findById(id);
    }

    public TodoItem create(TodoItemRequestDTO itemRequest) {
        TodoItem createdTodoItem = new TodoItem();

        this.apply(createdTodoItem, itemRequest);

        todoItemRepository.save(createdTodoItem);

        return createdTodoItem;
    }

    public TodoItem upsertById(Long id, TodoItemRequestDTO itemRequest) {

        return todoItemRepository.findById(id)
                .map(todo -> {
                    this.apply(todo, itemRequest);

                    return todoItemRepository.save(todo);
                })
                .orElseGet(() -> this.create(itemRequest));
    }

    public void deleteById(Long id) {
        todoItemRepository.deleteById(id);
    }

    private void apply(TodoItem todo, TodoItemRequestDTO itemRequest) {
        itemRequest.title().ifPresent(todo::setTitle);
        itemRequest.content().ifPresent(todo::setContent);
        itemRequest.dueDate().ifPresent(todo::setDueDate);
        itemRequest.priority().ifPresent((val) -> todo.setPriority(Priority.valueOf(val)));
        itemRequest.authorId().flatMap(authorRepository::findById).ifPresent(todo::setAuthor);
        itemRequest.todoGroupId().flatMap(todoGroupRepository::findById).ifPresent(todo::setTodoGroup);
    }
}
