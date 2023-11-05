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
//        Guide guide = new Guide("Trainer 004");
//        Guide guide1 = new Guide("Trainer 005");
//        Student student = new Student("Bhavik","Vashi", guide);
//        Student student1 = new Student("Raj", "Patel", guide1);
//        Student student2 = new Student("Meet", "Patel", guide1);
          Session session = null;

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();

           Guide guide2 = session.get(Guide.class, 1L);
           Guide guide3 = session.get(Guide.class, 2L);

            System.out.println(guide2 + ": " + guide2.getStudentsList());
            System.out.println(guide3 + ": " + guide3.getStudentsList());


            session.getTransaction().commit();

        }
        catch (Exception exception){
            if(session != null) session.getTransaction().rollback();
            System.out.println("Exception : "+ exception.getMessage());
        }
        finally {
            if(session != null) session.close();
        }

    }
}
