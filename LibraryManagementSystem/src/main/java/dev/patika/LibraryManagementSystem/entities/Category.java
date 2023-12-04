package dev.patika.LibraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany(mappedBy = "bookCategoryList")
    @JsonIgnoreProperties("bookCategoryList")
    private List<Book> categoryBookList;

}
