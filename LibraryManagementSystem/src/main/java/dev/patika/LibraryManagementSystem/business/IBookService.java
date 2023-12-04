package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Book;

import java.util.List;

public interface IBookService {

    Book getById(Long id);

    Book findById(Long id);

    Book save(Book book);

    void delete(Long id);

    Book update(Book book);
    List<Book> findAll();

}
