package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    Collection<Room> findRoomByName(String name);

    Room findRoomById(Integer id);
}
