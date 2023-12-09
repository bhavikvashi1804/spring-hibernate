package com.bhavik.service;

import com.bhavik.model.guide.book.Book;
import com.bhavik.model.guide.book.BookId;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


@Service
public class BookService {

    @Autowired
    SessionFactory sessionFactory;

    @PostConstruct
    public void doSetUp(){
        doDummyInsert();
    }


    private void doDummyInsert(){
        Session session = null;
        BookId bookId = new BookId("Life of Pie", "English");
        Book book = new Book(bookId,1000L);

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();

            session.save(book);

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
