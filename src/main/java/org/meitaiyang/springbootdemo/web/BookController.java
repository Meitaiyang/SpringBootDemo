package org.meitaiyang.springbootdemo.web;

import org.meitaiyang.springbootdemo.model.Book;
import org.meitaiyang.springbootdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Get all books
     * @return
     */
    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.findAll();
    }

    @PostMapping("/books")
    public Book post(@RequestParam String name,
                     @RequestParam String author,
                     @RequestParam int status,
                     @RequestParam String description) {
        Book book = new Book();
        book.setName(name);
        book.setAuthor(author);
        book.setStatus(status);
        book.setDescription(description);

        return bookService.save(book);
    }

    @GetMapping("/books/{id}")
    public Book getOne(@PathVariable long id){
        return bookService.findById(id);
    }

    @PutMapping("/books")
    public Book update(
            @RequestParam long id,
            @RequestParam String name,
            @RequestParam String author,
            @RequestParam int status,
            @RequestParam String description
    ) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setAuthor(author);
        book.setStatus(status);
        book.setDescription(description);

        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteOne(@PathVariable long id) {
        bookService.deleteById(id);
    }

    @PostMapping("/books/by/author")
    public List<Book> findByAuthor(@RequestParam String author) {
        return bookService.findByAuthor(author);
    }

    @PostMapping("/books/by/author/status")
    public List<Book> findByAuthorAndStatus(@RequestParam String author, @RequestParam int status) {
        return bookService.findByAuthorAndStatus(author, status);
    }

}
