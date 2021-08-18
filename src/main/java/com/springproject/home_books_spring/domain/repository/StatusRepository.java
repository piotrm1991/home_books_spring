package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
