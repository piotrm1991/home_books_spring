package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.domain.entites.Room;
import com.springproject.home_books_spring.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class RoomController {

    @Autowired
    RoomService roomService;

    @RequestMapping("/rooms")
    public String getAllRooms(Model model) {
        List<Room> allRooms = this.roomService.getAllRooms();
        model.addAttribute("rooms", allRooms);
        return "rooms";
    }

    @RequestMapping(value = "/rooms", method = RequestMethod.POST)
    public String saveRoom(@Valid Room room, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "roomForm";
        } else {
            this.roomService.addRoom(room);
            return "redirect:/rooms";
        }
    }

    @RequestMapping("/room")
    public String createRoom(Model model) {
        model.addAttribute("room", new Room());
        return "roomForm";
    }
}
