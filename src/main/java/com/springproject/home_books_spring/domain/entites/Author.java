package com.springproject.home_books_spring.domain.entites;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Author")
@Table(name = "AUTHOR")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_author")
    private Integer id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 40, message = "Author First Name should be from 2 to 40 letters")
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 2, max = 40, message = "Author Last Name should be from 2 to 40 letters")
    private String lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
