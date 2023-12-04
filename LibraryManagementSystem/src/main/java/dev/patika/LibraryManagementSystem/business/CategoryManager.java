package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Category;
import dev.patika.LibraryManagementSystem.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements ICategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getById(Long id) {
        return this.categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public String delete(Long id) {
        Category category = this.getById(id);
        if (!category.getCategoryBookList().isEmpty()) {
            return "This category has some books. You can't delete it.";
        }
        this.categoryRepo.delete(category);
        return "";
    }

    @Override
    public Category update(Category category) {
        if (category.getId() == 0) {
            throw new RuntimeException("Please write a valid id");
        }
        return this.categoryRepo.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }
}
