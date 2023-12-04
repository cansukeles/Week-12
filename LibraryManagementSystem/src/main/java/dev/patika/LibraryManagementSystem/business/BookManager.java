package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Book;
import dev.patika.LibraryManagementSystem.repository.BookRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookManager implements IBookService {

    private final BookRepo bookRepo;

    public BookManager(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }


    @Override
    public Book getById(Long id) {
        return this.bookRepo.findById(id).orElseThrow();
    }

    @Override
    public Book findById(Long id) {
        return this.bookRepo.findById(id).orElseThrow();
    }


    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public void delete(Long id) {
        this.bookRepo.delete(this.getById(id));
    }

    @Override
    public Book update(Book book) {
        if (book.getId() == 0) {
            throw new RuntimeException("Please write a valid id");
        }
        return this.bookRepo.save(book);
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepo.findAll();
    }
}
