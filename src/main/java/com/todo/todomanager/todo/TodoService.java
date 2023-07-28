package com.todo.todomanager.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos() {
        Iterable<Todo> todos = todoRepository.findAll();
        return (List<Todo>) todos;
    }
    public Optional<Todo> getTodo(int todoId) {
        Optional<Todo> todoOptional = todoRepository.findById(todoId);
        return todoOptional;
    }

    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public void deleteTodo(int todoId) {
        todoRepository.deleteById(todoId);
    }

}
