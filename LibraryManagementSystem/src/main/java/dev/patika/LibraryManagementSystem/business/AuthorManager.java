package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Author;
import dev.patika.LibraryManagementSystem.repository.IAuthorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorManager implements IAuthorService {

    private final IAuthorRepo authorRepo;

    public AuthorManager(IAuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @Override
    public Author getById(Long id) {
        return this.authorRepo.findById(id).orElseThrow();
    }

    @Override
    public Author save(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public void delete(Long id) {
        this.authorRepo.delete(this.getById(id));
    }

    @Override
    public Author update(Author author) {
        return this.authorRepo.save(author);
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepo.findAll();
    }
}
