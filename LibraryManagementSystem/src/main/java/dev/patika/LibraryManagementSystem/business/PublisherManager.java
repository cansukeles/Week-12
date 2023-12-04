package dev.patika.LibraryManagementSystem.business;

import dev.patika.LibraryManagementSystem.entities.Publisher;
import dev.patika.LibraryManagementSystem.repository.PublisherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherManager implements IPublisherService {

    private final PublisherRepo publisherRepo;

    public PublisherManager(PublisherRepo publisherRepo) {
        this.publisherRepo = publisherRepo;
    }

    @Override
    public Publisher getById(Long id) {
        return this.publisherRepo.findById(id).orElseThrow();
    }

    @Override
    public Publisher save(Publisher publisher) {
        return this.publisherRepo.save(publisher);
    }


    @Override
    public void delete(Long id) {
        this.publisherRepo.delete(this.getById(id));
    }

    @Override
    public Publisher update(Publisher publisher) {
        if(publisher.getId() == 0){
            throw new RuntimeException("Please write a valid id");
        }
        return this.publisherRepo.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return this.publisherRepo.findAll();
    }
}
