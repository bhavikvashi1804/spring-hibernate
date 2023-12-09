package com.bhavik.model.guide.book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    // properties
    @EmbeddedId
    private BookId bookId;
    private Long price;
    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private Set<Author> authorList = new HashSet<>();

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
    public Set<Author> getAuthorList() {
        return authorList;
    }
    public void setAuthorList(Set<Author> authorList) {
        this.authorList = authorList;
    }
    public void addAuthor(Author author){
        author.setBook(this);
        this.authorList.add(author);
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
                ", authors=" + authorList+
                '}';
    }
}
