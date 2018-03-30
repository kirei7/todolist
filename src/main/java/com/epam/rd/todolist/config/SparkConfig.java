package com.epam.rd.todolist.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static spark.Spark.port;
import static spark.Spark.staticFiles;

public class SparkConfig {
    private final Logger logger = LoggerFactory.getLogger(SparkConfig.class);
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
