//package com.bhavik.model.guide.book;
//
//import jakarta.persistence.*;
//
//@Entity
//@Table(name = "author_tb_details")
//public class Author {
//
//    //properties
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String name;
//
//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "fk_title", referencedColumnName = "title"),
//            @JoinColumn(name = "fk_language", referencedColumnName = "language")
//    })
//    private Book book;
//
//
//    // getters and setters
//    public Long getId() {
//        return id;
//    }
//    public void setId(Long id) {
//        this.id = id;
//    }
//    public String getName() {
//        return name;
//    }
//    public void setName(String name) {
//        this.name = name;
//    }
//    public Book getBook() {
//        return book;
//    }
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    // constructor
//    public Author(){
//    }
//    public Author(String name) {
//        this.name = name;
//    }
//
//
//    // methods
//    @Override
//    public String toString() {
//        return "Author{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", book=" + book +
//                '}';
//    }
//}
