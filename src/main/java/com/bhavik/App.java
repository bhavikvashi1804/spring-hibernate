package com.bhavik;

import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.TextEncryptor;
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

        System.out.println(appData.getDataSourceUserName());
        System.out.println(appData.getDataSourcePsd());

    }
}
