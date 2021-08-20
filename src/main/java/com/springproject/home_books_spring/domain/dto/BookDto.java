package com.springproject.home_books_spring.domain.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BookDto {

    private Integer id;

    @NotNull
    private String name;

    @NotNull
    private Integer idAuthor;

    private String authorFirstName;

    private String authorLastName;

    private Optional<Integer> idStatus;

    @NotNull
    private Integer idStatusType;

    private String statusTypeName;

    private Date dateUp;

    private String comment;

    @NotNull
    private Integer idPublisher;

    private String publisherName;

    @NotNull
    private Integer idShelf;

    private String shelfLetter;

    private Integer shelfNumber;

    private Integer idRoom;

    private String roomName;
}
