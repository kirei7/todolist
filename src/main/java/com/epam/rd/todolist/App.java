package com.epam.rd.todolist;

import com.epam.rd.todolist.injection.TodoListAppInjector;
import com.epam.rd.todolist.controller.ApiController;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    private static Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        logger.info("Starting application");
        Injector injector = Guice.createInjector(new TodoListAppInjector());

        ApiController spark = injector.getInstance(ApiController.class);

        spark.init();
        
    }
}
