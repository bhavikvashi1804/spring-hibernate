package com.bhavik.service;


import com.bhavik.model.guide.Guide;
import com.bhavik.model.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class StudentService {

    @Autowired
    SessionFactory sessionFactory;


    @PostConstruct
    public void insertDummyData(){
        Guide guide = new Guide("Trainer 001");
        Student student = new Student("Bhavik","Vashi", guide);

        Session session = null;

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            session.save(guide);
            session.save(student);

            session.getTransaction().commit();

        }
        catch (Exception exception){
            if(session != null) session.getTransaction().rollback();
            System.out.printf("Exception : "+ exception.getMessage());
        }
        finally {
            if(session != null) session.close();
        }

    }
}
