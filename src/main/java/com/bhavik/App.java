package com.bhavik;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        String applicationName = applicationContext.getBean(String.class, "applicationName");

        AppData appData = applicationContext.getBean(AppData.class);
        System.out.println(appData.getAppName());
    }
}
