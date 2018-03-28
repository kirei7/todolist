package com.epam.rd.todolist.service;

import com.epam.rd.todolist.entity.TodoNote;

import java.util.List;

public interface TodoListService {
    List<TodoNote> getNotes();
    TodoNote save(TodoNote note);
    TodoNote remove(TodoNote note);
}
