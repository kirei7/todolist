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
    private Map<Long, String> notes = new ConcurrentHashMap<>();

    public TodoNoteDaoInMemory() {
        notes.put(counter.incrementAndGet(), "Refactor this crap");
        notes.put(counter.incrementAndGet(), "Do not forget that this is in-memory storage");
        notes.put(counter.incrementAndGet(), "Another useful reminder");
    }

    @Override
    public List<TodoNote> findAll() {
        return notes.entrySet().stream().map(e -> new TodoNote(e.getKey(), e.getValue())).collect(toList());
    }

    @Override
    public TodoNote save(TodoNote note) {
        if (note.id == null)
            note.id = counter.incrementAndGet();
        notes.put(note.id, note.text);
        return note;
    }

    @Override
    public TodoNote remove(TodoNote note) {
        String text = notes.remove(note.id);
        if (text == null)
            return null;
        else
        return new TodoNote(note.id, text);
    }

    private TodoNote getById(Long id) {
        String text = notes.get(id);
        if (text == null)
            return null;
        else
            return new TodoNote(id, text);
    }
}
