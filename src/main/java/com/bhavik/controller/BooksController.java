package com.bhavik.controller;

import com.bhavik.model.guide.book.Book;
import com.bhavik.service.BookService;
import com.bhavik.service.repo.HibernateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooksController {

    @Autowired
    BookService bookService;

    @Autowired
    HibernateRepo hibernateRepo;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList = new ArrayList<>();
        bookList = bookService.fetchAllBooks();

        if(bookList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            return new ResponseEntity<>(bookList, HttpStatus.OK);
        }
    }


    @GetMapping("/books/dummy")
    public ResponseEntity<Void> storeDummyBooks(){
        bookService.doDummyInsert();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("books/author/{name}")
    public ResponseEntity<Void> addAuthor(@PathVariable(name = "name") String authorName){
        hibernateRepo.addAuthor(authorName);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
