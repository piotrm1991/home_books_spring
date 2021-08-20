package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.config.MainConfig;
import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.entites.Book;
import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.domain.repository.BookRepository;
import com.springproject.home_books_spring.domain.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

    @Autowired
    BookRepository bookRepository;

    @Transactional
    public void addPublisher(Publisher publisher) {
        this.publisherRepository.save(publisher);
    }

    public List<Publisher> getAllPublishers() {
        return this.publisherRepository.findAll();
    }

    public Optional<Publisher> findById(Integer id) {
        return this.publisherRepository.findById(id);
    }

    @Transactional
    public void deletePublisher(Integer id) {
        Publisher toDelete = this.publisherRepository.findById(id).get();
        boolean flag = toDelete.getName() != MainConfig.DEFAULT_PUBLISHER_NAME;
        if (flag) {
            Publisher defaultPublisher = this.getDefaultPublisher();
            Collection<Book> booksOfPublisherToDelete = this.bookRepository.findByPublisherId(id);
            booksOfPublisherToDelete.stream().forEach(book -> {
                book.setPublisher(defaultPublisher);
                this.bookRepository.save(book);
            });
            this.publisherRepository.delete(toDelete);
        }
    }

    private Publisher getDefaultPublisher() {
        return this.publisherRepository.findPublisherByName(MainConfig.DEFAULT_PUBLISHER_NAME).stream().findAny().get();
    }

    @Transactional
    public void prepareDefaultPublisher() {
       this.publisherRepository
                .findPublisherByName(MainConfig.DEFAULT_PUBLISHER_NAME)
                .stream()
                .findAny()
                .orElse(this.publisherRepository.save(Publisher.builder().name(MainConfig.DEFAULT_PUBLISHER_NAME).build()));
    }


}
