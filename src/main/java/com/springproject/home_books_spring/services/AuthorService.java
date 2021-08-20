package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.config.MainConfig;
import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.entites.Book;
import com.springproject.home_books_spring.domain.repository.AuthorRepository;
import com.springproject.home_books_spring.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public void addAuthor(Author author) {
        this.authorRepository.save(author);
    }

    public List<Author> getAllAuthors() {
        return this.authorRepository.findAll();
    }

    public Optional<Author> findById(Integer id) {
        return this.authorRepository.findById(id);
    }

    @Transactional
    public void deleteAuthor(Integer id) {
        Author toDelete = this.authorRepository.findById(id).get();
        boolean flag = toDelete.getFirstName() != MainConfig.DEFAULT_AUTHOR_FIRST_NAME && toDelete.getLastName() != MainConfig.DEFAULT_AUTHOR_LAST_NAME;
        if (flag) {
            Collection<Book> bookOfAuthorToDelete = this.bookRepository.findByAuthorId(id);
            Author defaultAuthor = this.getDefaultAuthor();
            bookOfAuthorToDelete.stream().forEach(book -> {
                book.setAuthor(defaultAuthor);
                this.bookRepository.save(book);
            });
            this.authorRepository.delete(toDelete);
        }
    }

    private Author getDefaultAuthor() {
        return this.authorRepository.findByFirstNameAndLastName(MainConfig.DEFAULT_AUTHOR_FIRST_NAME, MainConfig.DEFAULT_AUTHOR_LAST_NAME).stream().findAny().get();
    }

    @Transactional
    public void prepareDefaultAuthor() {
        this.authorRepository
                .findByFirstNameAndLastName(MainConfig.DEFAULT_AUTHOR_FIRST_NAME, MainConfig.DEFAULT_AUTHOR_LAST_NAME)
                .stream()
                .findAny()
                .orElse(this.authorRepository.save(Author.builder()
                        .firstName(MainConfig.DEFAULT_AUTHOR_FIRST_NAME)
                        .lastName(MainConfig.DEFAULT_AUTHOR_LAST_NAME)
                        .build()));
    }
}
