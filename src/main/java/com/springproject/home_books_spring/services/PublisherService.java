package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.domain.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    @Autowired
    PublisherRepository publisherRepository;

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
}
