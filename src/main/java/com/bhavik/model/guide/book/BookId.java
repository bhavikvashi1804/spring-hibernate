package com.bhavik.model.guide.book;


import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookId implements Serializable {


    //properties
    private String title;
    private String language;


    // getters and setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }

    // constructor
    public BookId(){
    }
    public BookId(String title,String language){
        this.title = title;
        this.language = language;
    }

    //methods
    @Override
    public String toString() {
        return "BookId{" +
                "title='" + title + '\'' +
                ", language='" + language + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookId bookId = (BookId) o;
        return Objects.equals(title, bookId.title) && Objects.equals(language, bookId.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, language);
    }
}
