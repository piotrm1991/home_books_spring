package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Shelf;
import com.springproject.home_books_spring.services.ShelfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ShelfController {

    @Autowired
    ShelfService shelfService;

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
}
