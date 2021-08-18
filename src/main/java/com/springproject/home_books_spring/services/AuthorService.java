package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Transactional
    public void addAuthor(Author author) {
        this.authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }
}
