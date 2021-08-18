package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {

    Collection<Author> findAuthorsByFirstName(String firstName);

    Collection<Author> findAuthorsByLastName(String lastName);

    Collection<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
