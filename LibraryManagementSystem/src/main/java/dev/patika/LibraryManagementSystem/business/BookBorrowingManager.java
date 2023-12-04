package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Book;
import dev.patika.LibraryManagementSystem.entities.BookBorrowing;
import dev.patika.LibraryManagementSystem.repository.BookRepo;
import dev.patika.LibraryManagementSystem.repository.IBookBorrowingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookBorrowingManager implements IBookBorrowingService {

    private final IBookBorrowingRepo bookBorrowingRepo;
    private final BookRepo bookRepo;
    private final BookManager bookManager;


    public BookBorrowingManager(IBookBorrowingRepo bookBorrowingRepo, BookRepo bookRepo, BookManager bookManager) {
        this.bookBorrowingRepo = bookBorrowingRepo;

        this.bookRepo = bookRepo;
        this.bookManager = bookManager;
    }

    @Override
    public BookBorrowing getById(Long id) {
        return this.bookBorrowingRepo.findById(id).orElseThrow();
    }

    @Override
    public BookBorrowing save(BookBorrowing bookBorrowing) {
        System.out.println(bookBorrowing);
        Book book = bookRepo.findById(bookBorrowing.getBook().getId()).get();
        int stock = book.getStock();

        if (stock <= 0) {
            throw new RuntimeException("No stock found for this book.");
        }
        book.setStock(stock - 1);
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public void delete(Long id) {
        this.bookBorrowingRepo.delete(this.getById(id));
    }

    @Override
    public BookBorrowing update(BookBorrowing bookBorrowing) {
        return this.bookBorrowingRepo.save(bookBorrowing);
    }

    @Override
    public List<BookBorrowing> findAll() {
        return this.bookBorrowingRepo.findAll();
    }
}
