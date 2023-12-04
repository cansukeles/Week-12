package dev.patika.LibraryManagementSystem.repository;

import dev.patika.LibraryManagementSystem.entities.BookBorrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowingRepo extends JpaRepository<BookBorrowing, Long> {
}
