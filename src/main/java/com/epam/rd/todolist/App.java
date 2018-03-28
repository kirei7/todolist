package com.epam.rd.todolist;

import com.epam.rd.todolist.spark.SparkConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Injector injector = Guice.createInjector();

        SparkConfig spark = injector.getInstance(SparkConfig.class);

        spark.init();
        
    }
}
