package com.epam.rd.todolist.entity;

import java.util.Objects;

public class TodoNote {
    public Long id;
    public String text;

    public TodoNote(){}
    public TodoNote(String text){
        this.text = text;
    }
    public TodoNote(long id, String text){
        this.id = id;
        this.text = text;
    }

    public TodoNote clone() {
        return new TodoNote(id, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoNote)) return false;
        TodoNote todoNote = (TodoNote) o;
        return id == todoNote.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "TodoNote{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
