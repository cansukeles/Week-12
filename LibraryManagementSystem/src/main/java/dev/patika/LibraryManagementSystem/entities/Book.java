package dev.patika.LibraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "book_name", length = 150)
    private String name;

    @Column(name = "book_publication_year")
    private int publicationYear;

    @Column(name = "book_stock")
    private int stock;

    @JsonIgnoreProperties("authorBookList")
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book2categories",
            joinColumns = {@JoinColumn(name = "book2categories_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2categories_category_id")}
    )
    private List<Category> bookCategoryList;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_publisher_id", referencedColumnName = "publisher_id")
    @JsonBackReference
    private Publisher publisher;

    @OneToMany(mappedBy = "book")
    @JsonBackReference
    @JsonIgnoreProperties("book")
    private List<BookBorrowing> bookBorrowing;


}
