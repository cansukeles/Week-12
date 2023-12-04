package dev.patika.LibraryManagementSystem.controller;

import dev.patika.LibraryManagementSystem.business.IBookBorrowingService;
import dev.patika.LibraryManagementSystem.entities.BookBorrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-borrowing")
public class BookBorrowingController {

    private final IBookBorrowingService bookBorrowingService;

    @Autowired
    public BookBorrowingController(IBookBorrowingService bookBorrowingService) {
        this.bookBorrowingService = bookBorrowingService;
    }
    @GetMapping("/all")
    public List<BookBorrowing> findAll(){
        return this.bookBorrowingService.findAll();
    }

    @GetMapping("{id}")
    public BookBorrowing getById(@PathVariable("id") Long id){
        return this.bookBorrowingService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BookBorrowing save(@RequestBody BookBorrowing bookBorrowing){
        return this.bookBorrowingService.save(bookBorrowing);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public BookBorrowing update(@RequestBody BookBorrowing bookBorrowing){
        BookBorrowing updateBb = this.bookBorrowingService.getById(bookBorrowing.getId());
        updateBb.setBook(bookBorrowing.getBook());
        updateBb.setBorrowerName(bookBorrowing.getBorrowerName());
        updateBb.setBorrowerEmail(bookBorrowing.getBorrowerEmail());
        return this.bookBorrowingService.update(updateBb);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        this.bookBorrowingService.delete(id);
    }
}
