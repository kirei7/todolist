package com.epam.rd.todolist;

import com.epam.rd.todolist.spark.SparkConfig;
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
        Injector injector = Guice.createInjector();

        SparkConfig spark = injector.getInstance(SparkConfig.class);

        spark.init();
        
    }
}
