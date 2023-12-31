package com.bhavik.model.guide.book;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_tb_details")
public class Book {

    // properties
    @EmbeddedId
    private BookId bookId;
    private Long price;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "book", orphanRemoval = true)
    private List<Author> authorList = new ArrayList<>();

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
    public List<Author> getAuthorList() {
        return authorList;
    }
    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
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
                ", authorList=" + authorList +
                '}';
    }
    public void addAuthor(Author author){
        author.setBook(this);
        this.authorList.add(author);
    }

    public void removeAuthor(Author author){
        //author.setBookId(null);
        this.authorList.remove(author);
        author.setBook(null);
    }
}
