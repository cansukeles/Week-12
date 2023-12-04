package dev.patika.LibraryManagementSystem.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherDto {

    private Long id;
    private String name;
    private int establishmentYear;

}
