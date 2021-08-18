package com.springproject.home_books_spring.domain.entites;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "Publisher")
@Table(name = "PUBLISHER")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_publisher")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 40, message = "Publisher name should be from 2 to 40 letters")
    private String name;

    public Publisher(String name) {
        this.name = name;
    }
}