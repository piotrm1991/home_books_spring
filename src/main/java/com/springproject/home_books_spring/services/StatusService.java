package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.Status;
import com.springproject.home_books_spring.domain.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    StatusRepository statusRepository;

    public Optional<Status> findById(Integer id) {
        return this.statusRepository.findById(id);
    }
}
