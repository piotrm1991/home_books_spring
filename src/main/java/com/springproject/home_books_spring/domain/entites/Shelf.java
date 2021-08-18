package com.springproject.home_books_spring.domain.entites;

import lombok.*;

import javax.persistence.*;

@Entity(name = "Shelf")
@Table(name = "SHELF")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Shelf{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shelf")
    private Integer id;

    @Column(name = "letter")
    private String letter;

    @Column(name = "number")
    private Integer number;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "id_room")
    private Room room;

    public Shelf(String letter, Integer number) {
        this.letter = letter;
        this.number = number;
    }
}
