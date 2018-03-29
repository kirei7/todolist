package com.epam.rd.todolist.controller;

import com.epam.rd.todolist.entity.TodoNote;
import com.epam.rd.todolist.service.TodoListService;
import com.google.gson.Gson;

import javax.inject.Inject;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

public class ApiController {

    private final String NOTES_PATH = "/notes";

    private Gson gson = new Gson();
    private TodoListService service;

    @Inject
    public ApiController(TodoListService service) {
        this.service = service;
    }


    public void init() {
        get("/hello", (req, res) -> "Hello World");

        get(NOTES_PATH,
                (req, res) -> service.getNotes(),
                gson::toJson);

        post(NOTES_PATH,
                (req, res) -> service.save(gson.fromJson(req.body(), TodoNote.class)));

        delete(NOTES_PATH,
                (req, res) -> service.remove(gson.fromJson(req.body(), TodoNote.class)));

    }
}
