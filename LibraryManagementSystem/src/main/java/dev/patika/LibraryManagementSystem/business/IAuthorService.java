package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Author;

import java.util.List;

public interface IAuthorService {

    Author getById(Long id);

    Author save(Author author);

    void delete(Long id);

    Author update(Author author);

    List<Author> findAll();


}
