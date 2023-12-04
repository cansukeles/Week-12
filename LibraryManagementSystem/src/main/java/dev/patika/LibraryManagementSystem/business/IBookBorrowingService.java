package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.BookBorrowing;

import java.util.List;

public interface IBookBorrowingService {

    BookBorrowing getById(Long id);
    BookBorrowing save(BookBorrowing bookBorrowing);

    void delete(Long id);
    BookBorrowing update(BookBorrowing bookBorrowing);

    List<BookBorrowing> findAll();
}
