package com.bhavik.service;

import com.bhavik.model.person.Address;
import com.bhavik.model.person.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class PersonService {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    public void doDummyInsert(){

        Address address = new Address(
                "J 203, Sainath Society",
                "Hansot Road",
                "Ankleshwar",
                "Bharuch",
                "Gujarat",
                "India",
                393001L);

        Person person = new Person("Bhavik", "Vashi", address);


        Session session = null;

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();

            session.save(person);

            session.getTransaction().commit();
        }
        catch (Exception exception){
            System.out.println(exception.getMessage());
            if(session != null) session.getTransaction().rollback();
        }
        finally {
            if(session != null) session.close();
        }
    }
}
