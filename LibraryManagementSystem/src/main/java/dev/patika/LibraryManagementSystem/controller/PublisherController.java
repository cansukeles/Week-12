package dev.patika.LibraryManagementSystem.controller;

import dev.patika.LibraryManagementSystem.business.IPublisherService;
import dev.patika.LibraryManagementSystem.dto.requestDto.PublisherDto;
import dev.patika.LibraryManagementSystem.entities.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publisher")
public class PublisherController {
    private final IPublisherService publisherService;

    private final ModelMapper modelMapper;

    public PublisherController(IPublisherService publisherService, ModelMapper modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    public PublisherDto getById(@PathVariable("id") Long id) {
        return this.modelMapper.map(this.publisherService.getById(id), PublisherDto.class);
    }

    @GetMapping("/all")
    public List<Publisher> findAll() {
        return this.publisherService.findAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher save(@RequestBody Publisher publisher) {
        return this.publisherService.save(publisher);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Publisher update(@RequestBody Publisher publisher) {
        Publisher updatePublisher = this.publisherService.getById(publisher.getId());
        updatePublisher.setName(publisher.getName());
        updatePublisher.setAddress(publisher.getAddress());
        updatePublisher.setEstablishmentYear(publisher.getEstablishmentYear());
        return this.publisherService.update(updatePublisher);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.publisherService.delete(id);
    }
}
