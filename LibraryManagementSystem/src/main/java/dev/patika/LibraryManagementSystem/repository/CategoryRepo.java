package dev.patika.LibraryManagementSystem.repository;

import dev.patika.LibraryManagementSystem.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {

}
