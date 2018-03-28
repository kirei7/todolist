package com.epam.rd.todolist.spark;

import com.epam.rd.todolist.service.TodoListService;
import com.google.gson.Gson;

import javax.inject.Inject;
import java.util.Arrays;

import static spark.Spark.get;

public class SparkConfig {

    private Gson gson = new Gson();
    private TodoListService service;

    @Inject
    public SparkConfig(TodoListService service) {
        this.service = service;
    }


    public void init() {
        get("/hello", (req, res) -> "Hello World");

        get("/notes",
                (req, res) -> service.getNotes(),
                gson::toJson);
    }
}
