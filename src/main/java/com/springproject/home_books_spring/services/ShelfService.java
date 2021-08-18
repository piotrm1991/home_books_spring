package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.Shelf;
import com.springproject.home_books_spring.domain.repository.ShelfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ShelfService {

    @Autowired
    ShelfRepository shelfRepository;

    @Autowired
    EntityManager entityManager;

    @Transactional
    public void addShelf(Shelf shelf) {
        entityManager.merge(shelf);
    }

    public List<Shelf> getAllShelves() {
        return this.shelfRepository.findAll();
    }

    public List<Shelf> getShelvesByRoom(Integer id) {
        return (List<Shelf>) this.shelfRepository.findByRoomId(id);
    }

    public Shelf getShelfById(Integer id) {
        return this.shelfRepository.findById(id).get();
    }
}
