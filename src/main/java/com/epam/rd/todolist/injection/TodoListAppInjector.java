package com.epam.rd.todolist.injection;

import com.epam.rd.todolist.dao.TodoNoteDao;
import com.epam.rd.todolist.dao.TodoNoteDaoInMemory;
import com.epam.rd.todolist.service.TodoListService;
import com.epam.rd.todolist.service.TodoListServiceImpl;
import com.google.inject.AbstractModule;

public class TodoListAppInjector extends AbstractModule {
    @Override
    protected void configure() {
        bind(TodoNoteDao.class).to(TodoNoteDaoInMemory.class);
        bind(TodoListService.class).to(TodoListServiceImpl.class);
    }
}
