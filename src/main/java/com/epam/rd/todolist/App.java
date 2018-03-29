package com.epam.rd.todolist;

import com.epam.rd.todolist.config.SparkConfig;
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
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector(new TodoListAppInjector());

        injector.getInstance(SparkConfig.class);
        injector.getInstance(ApiController.class).init();
    }
}
