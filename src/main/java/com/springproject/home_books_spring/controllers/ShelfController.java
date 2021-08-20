package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.dto.ShelfDto;
import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.entites.Shelf;
import com.springproject.home_books_spring.services.RoomService;
import com.springproject.home_books_spring.services.ShelfService;
import com.springproject.home_books_spring.util.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ShelfController {

    @Autowired
    ShelfService shelfService;

    @Autowired
    RoomService roomService;

    @Autowired
    DtoMapper dtoMapper;

    @RequestMapping("shelves")
    public String getAllShelves(Model model) {
        List<Shelf> allShelves = this.shelfService.getAllShelves();
        model.addAttribute("shelves", allShelves);
        return "shelves";
    }

    @RequestMapping("/shelves/room/{id}")
    public String getShelvesByRoom(@PathVariable("id") Integer id, Model model) {
        List<Shelf> shelvesByRoom = this.shelfService.getShelvesByRoom(id);
        model.addAttribute("shelves", shelvesByRoom);
        return "shelves";
    }

    @RequestMapping(value = "/shelves", method = RequestMethod.POST)
    public String saveShelf(@Valid ShelfDto shelfDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "shelfForm";
        } else {
            this.shelfService.addShelf(this.dtoMapper.fromShelfDto(shelfDto));
            return "redirect:/shelves";
        }
    }

    @RequestMapping("/shelf")
    public String createShelf(Model model) {
        model.addAttribute("shelf", new ShelfDto());
        model.addAttribute("rooms", this.roomService.getAllRooms());
        return "shelfForm";
    }
}
