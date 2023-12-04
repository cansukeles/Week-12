package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Book;
import dev.patika.LibraryManagementSystem.entities.Category;

import java.util.List;

public interface ICategoryService {

    Category getById(Long id);

    Category save(Category category);

    String delete(Long id);

    Category update(Category category);

    List<Category> findAll();

}
