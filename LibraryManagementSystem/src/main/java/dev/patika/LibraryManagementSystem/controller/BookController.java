package dev.patika.LibraryManagementSystem.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.patika.LibraryManagementSystem.business.IBookService;
import dev.patika.LibraryManagementSystem.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final IBookService bookService;

    @Autowired
    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String home() {
        return "Book page";
    }

    @GetMapping("/all")
    public List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book getById(@PathVariable("id") Long id) {
        return this.bookService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Book save(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Book update(@RequestBody Book book) {
        Book updateBook = this.bookService.getById(book.getId());
        updateBook.setName(book.getName());
        updateBook.setStock(book.getStock());
        updateBook.setPublicationYear(book.getPublicationYear());
        return this.bookService.update(updateBook);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
    }


}
