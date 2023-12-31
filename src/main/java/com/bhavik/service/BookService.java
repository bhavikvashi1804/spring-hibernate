package com.bhavik.service;
import com.bhavik.model.guide.book.Book;
import com.bhavik.model.guide.book.BookId;
import com.bhavik.service.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.util.List;


@Service
public class BookService {

    @Autowired
    EntityManager entityManager;

    @Autowired
    BooksRepo booksRepo;

    public List<Book> fetchAllBooks(){
        List<Book> bookList = booksRepo.findAll();
        return  bookList;
    }


    public void storeBook(Book book){
        booksRepo.save(book);
    }


    @PostConstruct
    public void doSetUp(){
        doDummyInsert();
    }


    public void doDummyInsert(){
        Book b1  = new Book(
                new BookId("The Queen of Spades and Other Russian Stories","English"),
                1000L
        );

        Book b2 = new Book(
                new BookId("The Queen of Spades and Other Russian Stories","French"),
                1500L
        );

        storeBook(b1);
        storeBook(b2);
    }

}
