package org.meitaiyang.springbootdemo.repository;

import org.meitaiyang.springbootdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);

    List<Book> findByAuthorAndStatus(String author, int status);

}
