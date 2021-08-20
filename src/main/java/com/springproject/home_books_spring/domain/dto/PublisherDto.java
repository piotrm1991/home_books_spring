package com.springproject.home_books_spring.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PublisherDto {

    private Integer id;

    @NotNull
    @Size(min = 2, max = 40, message = "Publisher name should be from 2 to 40 letters")
    private String name;

    private Integer nBooks;
}
