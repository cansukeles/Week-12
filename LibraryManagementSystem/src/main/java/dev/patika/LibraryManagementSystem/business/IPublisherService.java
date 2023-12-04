package dev.patika.LibraryManagementSystem.business;
import dev.patika.LibraryManagementSystem.entities.Publisher;

import java.util.List;

public interface IPublisherService {

    Publisher getById(Long id);

    Publisher save(Publisher publisher);

    void delete(Long id);
    Publisher update(Publisher publisher);
    List<Publisher> findAll();

}
