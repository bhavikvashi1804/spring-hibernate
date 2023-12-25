package com.bhavik.service.repo;

import com.bhavik.model.guide.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
public class HibernateRepo {


    @Autowired
    EntityManager entityManager;


    @Transactional
    public void storeMessage(){
        Message m1 = new Message("Home Text");
        entityManager.persist(m1);
    }
}
