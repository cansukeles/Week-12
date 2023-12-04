package dev.patika.LibraryManagementSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", columnDefinition = "serial")
    private Long id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "publisher_establishmentYear")
    private int establishmentYear;

    @Column(name = "publisher_address")
    private String address;


    @OneToMany(mappedBy = "publisher", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JsonIgnore
    private List<Book> publisherBookList;

}
