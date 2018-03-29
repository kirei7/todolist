package com.epam.rd.todolist.dao;

import com.epam.rd.todolist.entity.TodoNote;

import javax.inject.Singleton;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.stream.Collectors.toList;

@Singleton
public class TodoNoteDaoInMemory implements TodoNoteDao {

    private AtomicLong counter = new AtomicLong();
    private Map<Long, TodoNote> notes = new ConcurrentHashMap<>();

    public TodoNoteDaoInMemory() {
        notes.put(counter.incrementAndGet(), new TodoNote(counter.get(), "Refactor this crap"));
        notes.put(counter.incrementAndGet(), new TodoNote(counter.get(), "Do not forget that this is in-memory storage"));
        notes.put(counter.incrementAndGet(), new TodoNote(counter.get(), "Another useful reminder"));
    }

    @Override
    public List<TodoNote> findAll() {
        return notes.entrySet().stream().map(e -> e.getValue()).collect(toList());
    }

    @Override
    public TodoNote save(TodoNote note) {
        if (note.id == null)
            note.id = counter.incrementAndGet();
        notes.put(note.id, note);
        return note;
    }

    @Override
    public TodoNote remove(TodoNote note) {
        return notes.remove(note.id);
    }

    private TodoNote getById(Long id) {
        return notes.get(id);
    }
}
