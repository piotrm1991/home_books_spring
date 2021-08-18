package com.springproject.home_books_spring.domain.repository;


import com.springproject.home_books_spring.domain.entites.StatusType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StatusTypeRepository extends JpaRepository<StatusType, Integer> {
    Collection<StatusType> findStatusTypeByName(String name);
}
