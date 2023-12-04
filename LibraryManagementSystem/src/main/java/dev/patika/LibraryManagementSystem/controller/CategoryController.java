package dev.patika.LibraryManagementSystem.controller;

import dev.patika.LibraryManagementSystem.business.ICategoryService;
import dev.patika.LibraryManagementSystem.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private final ICategoryService categoryService;

    @Autowired
    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public List<Category> findAll() {
        return this.categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable("id") Long id) {
        return this.categoryService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category) {
        return this.categoryService.save(category);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Category update(@RequestBody Category category) {
        Category updateCategory = this.categoryService.getById(category.getId());
        updateCategory.setName(category.getName());
        updateCategory.setDescription(category.getDescription());
        return this.categoryService.update(updateCategory);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        this.categoryService.delete(id);
        return "";
    }
}
