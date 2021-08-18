package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    Collection<Publisher> findPublisherByName(String name);
}
