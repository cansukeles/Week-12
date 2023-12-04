package dev.patika.LibraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_borrowing")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookBorrowing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookBorrowing_id")
    private Long id;

    @Column(name = "borrower_name")
    private String borrowerName;

    @Column(name = "borrower_email")
    private String borrowerEmail;

    @Column(name = "borrowing_date")
    @Temporal(TemporalType.DATE)
    private LocalDate borrowingDate;

    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private LocalDate returnDate;

    @ManyToOne(fetch = FetchType.LAZY)
    // silinebilir
    @JsonBackReference
    // silinebilir
    @JsonIgnoreProperties("bookBorrowing")
    @JoinColumn(name = "book_id", referencedColumnName = "book_id")
    private Book book;


}