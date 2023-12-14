package com.bhavik.service.repo;


import com.bhavik.model.guide.book.Book;
import com.bhavik.model.guide.book.BookId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends JpaRepository<Book, BookId> {
}
