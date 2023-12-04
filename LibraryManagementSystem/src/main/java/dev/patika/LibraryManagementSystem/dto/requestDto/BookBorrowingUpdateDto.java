package dev.patika.LibraryManagementSystem.dto.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingUpdateDto {


    private Long id;
    private String borrowerName;
    private String borrowerDate;
    private String returnDate;
}
