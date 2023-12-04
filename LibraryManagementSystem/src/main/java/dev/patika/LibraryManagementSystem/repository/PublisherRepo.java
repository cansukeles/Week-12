package dev.patika.LibraryManagementSystem.repository;

import dev.patika.LibraryManagementSystem.entities.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher, Long> {
    Publisher findById(int id);
}
