package com.bhavik.model.guide.book;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "book_tb_details")
public class Book {

    // properties
    @EmbeddedId
    private BookId bookId;
    private Long price;


    // getters and setters
    public BookId getBookId() {
        return bookId;
    }
    public void setBookId(BookId bookId) {
        this.bookId = bookId;
    }
    public Long getPrice() {
        return price;
    }
    public void setPrice(Long price) {
        this.price = price;
    }

    // constructor
    public Book(){
    }
    public Book(BookId bookId){
        this.bookId = bookId;
    }
    public Book(BookId bookId, Long price) {
        this.bookId = bookId;
        this.price = price;
    }

    // methods
    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", price=" + price +
                '}';
    }
}
