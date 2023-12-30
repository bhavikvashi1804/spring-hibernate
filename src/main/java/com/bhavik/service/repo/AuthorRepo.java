package com.bhavik.service.repo;

import com.bhavik.model.guide.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepo extends JpaRepository<Author, Long> {
}
