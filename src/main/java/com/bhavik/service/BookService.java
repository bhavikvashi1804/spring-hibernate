package com.bhavik.service;

import com.bhavik.model.guide.book.Author;
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
        BookId bookId = new BookId("The Illuminae Files", "English");
        Book book = new Book(bookId,2000L);
        Author author = new Author("Amie Kaufman");
        book.addAuthor(author);
        Author author1 = new Author("Jay Kristoff");
        book.addAuthor(author1);

        try{
            session = sessionFactory.openSession();
            session.getTransaction().begin();

            session.persist(book);

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
