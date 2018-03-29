package com.epam.rd.todolist.service;

import com.epam.rd.todolist.dao.TodoNoteDao;
import com.epam.rd.todolist.entity.TodoNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class TodoListServiceImpl implements TodoListService{
    private Logger logger = LoggerFactory.getLogger(TodoListServiceImpl.class);

    private TodoNoteDao dao;

    @Inject
    public TodoListServiceImpl(TodoNoteDao dao) {
        this.dao = dao;
        logger.debug("Creating Service");
        logger.debug("Start content: " + dao.findAll());
    }

    @Override
    public List<TodoNote> getNotes() {
        return dao.findAll();
    }

    @Override
    public TodoNote findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public TodoNote changeStatus(TodoNote note) {
        note.isDone = !note.isDone;
        return dao.save(note);
    }

    @Override
    public TodoNote save(TodoNote note) {
        return dao.save(note);
    }

    @Override
    public TodoNote remove(TodoNote note) {
        return dao.remove(note);
    }
}
