package dev.patika.LibraryManagementSystem.dto.requestDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingSaveDto {

private Long id;

@NotBlank
private String borrowerName;

@Email
private String borrowerEmail;

private String borrowingDate;

@NotBlank
private Long bookId;
}
