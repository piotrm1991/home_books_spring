package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.StatusType;
import com.springproject.home_books_spring.domain.repository.StatusTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StatusTypeService {

    @Autowired
    StatusTypeRepository statusTypeRepository;

    @Transactional
    public void addStatusType(StatusType statusType) {
        this.statusTypeRepository.save(statusType);
    }

    public List<StatusType> getAllStatusTypes() {
        return this.statusTypeRepository.findAll();
    }

    public StatusType getById(Integer id) {
        return this.statusTypeRepository.findById(id).get();
    }
}
