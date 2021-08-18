package com.springproject.home_books_spring.domain.entites;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "StatusType")
@Table(name = "STATUS_TYPE")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StatusType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status_type")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 40, message = "Status Type Name should be from 2 to 40 letters")
    private String name;

    public StatusType(String name) {
        this.name = name;
    }
}