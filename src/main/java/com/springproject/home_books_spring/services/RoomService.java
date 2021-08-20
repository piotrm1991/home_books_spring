package com.springproject.home_books_spring.services;

import com.springproject.home_books_spring.domain.entites.Room;
import com.springproject.home_books_spring.domain.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Transactional
    public void addRoom(Room room) {
        this.roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    public Room findRoomByName(String name) {
        Room room = this.roomRepository.findRoomByName(name).stream().findFirst().get();
        return room;
    }

    public Room findRoomById(Integer idRoom) {
        return this.roomRepository.findRoomById(idRoom);
    }
}
