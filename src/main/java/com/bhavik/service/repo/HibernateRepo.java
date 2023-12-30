package com.bhavik.service.repo;

import com.bhavik.model.guide.book.Author;
import com.bhavik.model.guide.book.Book;
import com.bhavik.model.guide.book.BookId;
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

    @Transactional
    public void addAuthor(String authorName){
        Book b1 = entityManager.find(Book.class, new BookId("The Queen of Spades and Other Russian Stories", "English"));
        Author author = new Author(authorName);
        b1.addAuthor(author);
        entityManager.persist(author);
    }
}
