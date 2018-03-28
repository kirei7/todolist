package com.epam.rd.todolist.dao;

import com.epam.rd.todolist.entity.TodoNote;

import java.util.List;

public interface TodoNoteDao {
    List<TodoNote> findAll();
    TodoNote save(TodoNote note);
    TodoNote remove(TodoNote note);
}
