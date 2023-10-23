package com.bhavik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class HibernateConf {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String user;

    @Value("${datasource.psd}")
    private String psd;

    @Value("${datasource.driver-class-name}")
    private String driverClassName;

    @Autowired
    ResourceLoader resourceLoader;


    @Bean
    LocalSessionFactoryBean getLocalSessionFactoryBean(){
        LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();

        localSessionFactoryBean.setDataSource(dataSource());
        localSessionFactoryBean.setHibernateProperties(getHibernateProperties());
        localSessionFactoryBean.setMappingLocations(loadHibernateResources());
        localSessionFactoryBean.setPackagesToScan("com.bhavik.model");

        return localSessionFactoryBean;
    }



    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUsername(user);
        dataSource.setPassword(psd);

        return  dataSource;
    }



    // Hibernate Properties
    private final Properties getHibernateProperties(){
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql","true");
        properties.setProperty("hibernate.format_sql","true");
        properties.setProperty("hibernate.hbm2ddl.auto","update");
        properties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
        return properties;
    }


    // Load the Hibernate Configuration Files
    private Resource[] loadHibernateResources(){
        Resource[] resources = null;

        try{
            resources = ResourcePatternUtils.getResourcePatternResolver(resourceLoader).getResources("classpath*:/com/bhavik/model/**/*.hbm.xml");
        }
        catch (Exception exception){
            System.out.printf("Exception occcured while loading the HBM files: " + exception.getMessage());
        }

        return resources;
    }




}
