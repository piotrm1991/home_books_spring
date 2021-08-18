package com.springproject.home_books_spring.domain.entites;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity(name = "Room")
@Table(name = "ROOM")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_room")
    private Integer id;

    @Column(name = "name")
    @NotNull
    @Size(min = 2, max = 40, message = "Room Name should be from 2 to 40 letters")
    private String name;

    public Room(String name) {
        this.name = name;
    }
}
