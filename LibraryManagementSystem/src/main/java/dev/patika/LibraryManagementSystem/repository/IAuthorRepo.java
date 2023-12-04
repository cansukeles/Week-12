package dev.patika.LibraryManagementSystem.repository;

import dev.patika.LibraryManagementSystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface IAuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findByNameAndBirthDateAndCountry(String name, LocalDate birthDate,String country);
}
