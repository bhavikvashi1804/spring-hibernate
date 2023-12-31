package com.bhavik.model.guide.book;

import javax.persistence.*;

@Entity
@Table(name = "author_tb_details")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    @Column(name = "author_name")
    private String name;

    @Column(name = "lgcl_delete")
    private Boolean active;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "fk_title", referencedColumnName = "title"),
            @JoinColumn(name = "fk_lang", referencedColumnName = "lang")
    })
    private Book book;

    // getters and setters
    public Long getAuthorId() {
        return authorId;
    }
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }


    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    // constructor
    public Author(){
    }

    public Author(String name){
        this.name = name;
        this.active = true;
    }


    // methods

    @Override
    public String toString() {
        return "Author{" +
                "id=" + authorId +
                ", name='" + name + '\'' +
                ", active=" + active +
                '}';
    }
}
