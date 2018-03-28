package com.epam.rd.todolist.spark;

import com.google.gson.Gson;

import java.util.Arrays;

import static spark.Spark.get;

public class SparkConfig {

    private Gson gson = new Gson();



    public void init() {
        get("/hello", (req, res) -> "Hello World");

        get("/notes",
                (req, res) -> Arrays.asList("first note", " second note"),
                gson::toJson);
    }
}
