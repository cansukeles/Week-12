package dev.patika.LibraryManagementSystem.controller;

import dev.patika.LibraryManagementSystem.business.IAuthorService;
import dev.patika.LibraryManagementSystem.entities.Author;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final IAuthorService authorService;

    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/{id}")
    public Author getById(@PathVariable("id") Long id) {
        return this.authorService.getById(id);
    }

    @GetMapping("/all")
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Author save(@RequestBody Author author) {
        return this.authorService.save(author);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Author update(@RequestBody Author author) {
        Author updateAuthor = this.authorService.getById(author.getId());
        updateAuthor.setName(author.getName());
        updateAuthor.setCountry(author.getCountry());
        updateAuthor.setBirthDate(author.getBirthDate());
        return this.authorService.update(updateAuthor);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.authorService.delete(id);
    }
}
