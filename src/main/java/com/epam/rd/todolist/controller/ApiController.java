package com.epam.rd.todolist.controller;

import com.epam.rd.todolist.entity.TodoNote;
import com.epam.rd.todolist.service.TodoListService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import static spark.Spark.*;

public class ApiController {

    private static Logger logger = LoggerFactory.getLogger(ApiController.class);
    private final String NOTES_PATH = "/notes";

    private ObjectMapper mapper = new ObjectMapper();
    private TodoListService service;


    @Inject
    public ApiController(TodoListService service) {
        this.service = service;
    }


    public void init() {
        logger.info("init ");

        get("/hello", (req, res) -> "Hello World");

        get(NOTES_PATH,
                (req, res) -> service.getNotes(),
                mapper::writeValueAsString);

        post(NOTES_PATH,
                (req, res) -> service.save(mapper.readValue(req.body(), TodoNote.class)), mapper::writeValueAsString);

        post(NOTES_PATH + "/:id",
                (req, res) -> {
                    TodoNote note = service.findById(new Long(req.params(":id")));
                    return service.changeStatus(note);
                }, mapper::writeValueAsString);


        delete(NOTES_PATH,
                (req, res) -> service.remove(mapper.readValue(req.body(), TodoNote.class)), mapper::writeValueAsString);

    }
}
