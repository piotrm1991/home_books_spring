package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ShelfRepository extends JpaRepository<Shelf, Integer> {
    Collection<Shelf> findByRoomId(Integer idRoom);

    Collection<Shelf> findShelfByLetter(String letter);

    Collection<Shelf> findShelfByNumber(Integer number);
}
