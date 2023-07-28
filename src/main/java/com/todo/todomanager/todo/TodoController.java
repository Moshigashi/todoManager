package com.todo.todomanager.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoService.getTodos();
    }

    @PostMapping("/todos")
    public ResponseEntity<String> saveStudent(@RequestBody Todo todo) {
        Todo s=todoService.saveTodo(todo);
        return ResponseEntity.ok("todo successfully added");
    }

    @PutMapping("/todos/{todoId}")
    public ResponseEntity<?> updateTodo(@RequestParam int todoId, @RequestBody Todo todo) {
        Optional<Todo> todoCheck=todoService.getTodo(todoId);
        if(todoCheck.isPresent()) {
            todo.setTodoId(todoId);
            Todo s=todoService.saveTodo(todo);
            return ResponseEntity.ok(s);
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("todoId is not found");
    }

    @GetMapping("/todos/{todoId}")
    public ResponseEntity<?> getTodo(@PathVariable("todoId")int todoId){

        Optional<Todo> todo= todoService.getTodo(todoId);
        if(todo.isPresent()){
            Todo s= todo.get();
            return ResponseEntity.ok(s);
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("todoId is not found");
    }

    @DeleteMapping("/todos/{todoId}")
    public ResponseEntity<?> deleteTodo(@PathVariable("todoId") int todoId) {
        Optional<Todo> todo= todoService.getTodo(todoId);
        if(todo.isPresent()) {
            todoService.deleteTodo(todoId);
            return ResponseEntity.ok("todo deleted");
        }else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("todoId is not found");
    }

}
