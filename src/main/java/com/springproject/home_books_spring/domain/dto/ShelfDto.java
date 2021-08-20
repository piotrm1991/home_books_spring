package com.springproject.home_books_spring.domain.dto;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShelfDto {

    private Integer id;

    @NotNull
    @Size(min = 1, max = 3, message = "From 1 To 3")
    private String letter;

    @NotNull
    @Range(min = 1, max = 40, message = "From 1 to 40")
    private Integer number;

    private Integer idRoom;
}
