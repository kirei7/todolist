package com.epam.rd.todolist.config;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class SparkConfig {
    public SparkConfig() {
        staticFiles.location("/static");
        String portStr = System.getenv("PORT");
        int port;
        try {
            port = Integer.parseInt(portStr);
        } catch (Exception ex) {
            port = 8080;
        }
        port(port);
        /*String path = System.getProperty("user.dir") + "/src/main/resources/static";
        staticFiles.externalLocation(path);*/
    }
}
