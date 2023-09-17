package com.bhavik;

import org.jasypt.properties.EncryptableProperties;
import org.jasypt.util.text.BasicTextEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class AppConfig {

    @Bean
    public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        //propertySourcesPlaceholderConfigurer.setLocation(new ClassPathResource("application.properties"));
        configurer.setLocations(
                new ClassPathResource("application.properties")
                //new ClassPathResource("database.properties")
        );

        configurer.setPropertiesArray(encryptableProperties());
        return configurer;
    }

    @Bean
    EncryptableProperties encryptableProperties()  {
        EncryptableProperties encryptableProperties = new EncryptableProperties(getBasicTextEncryptor());
        try{
            ClassPathResource classPathResource = new ClassPathResource("database.properties");
            encryptableProperties.load(classPathResource.getInputStream());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  encryptableProperties;
    }


    @Bean
    public BasicTextEncryptor getBasicTextEncryptor(){
        BasicTextEncryptor basicTextEncryptor = new BasicTextEncryptor();
        basicTextEncryptor.setPassword("app-foo");
        return  basicTextEncryptor;
    }


}
