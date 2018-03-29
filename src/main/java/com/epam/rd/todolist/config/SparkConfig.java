package com.epam.rd.todolist.config;

import static spark.Spark.staticFiles;

public class SparkConfig {
    public SparkConfig() {
        //staticFiles.location("/static");
        String path = System.getProperty("user.dir") + "/src/main/resources/static";
        staticFiles.externalLocation(path);
    }
}
