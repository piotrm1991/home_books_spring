package com.springproject.home_books_spring.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class AuthorDto {

    private Integer id;

    @NotNull
    @Size(min = 2, max = 40, message = "First Name should be from 2 to 40 letters")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 40, message = "Last Name should be from 2 to 40 letters")
    private String lastName;

    private Integer nBooks;
}
