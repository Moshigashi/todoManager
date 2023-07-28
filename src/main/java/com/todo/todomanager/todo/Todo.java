package com.todo.todomanager.todo;

import jakarta.persistence.*;

@Entity
@Table(name="todo")

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int todoId;
    @Column(name = "description")
    private String todoDescription;
    @Column(name = "status")
    private boolean todoStatus;
    @Column(name = "assignment")
    private int todoAssignment;

    public Todo() {
    }

    public Todo(String todoDescription, boolean todoStatus, int todoAssignment) {
        this.todoDescription = todoDescription;
        this.todoStatus = todoStatus;
        this.todoAssignment = todoAssignment;
    }

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public boolean isTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(boolean todoStatus) {
        this.todoStatus = todoStatus;
    }

    public int getTodoAssignment() {
        return todoAssignment;
    }

    public void setTodoAssignment(int todoAssignment) {
        this.todoAssignment = todoAssignment;
    }
}
