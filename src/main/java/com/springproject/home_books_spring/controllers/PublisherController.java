package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.services.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @RequestMapping("/publishers")
    public String getAllPublishers(Model model) {
        List<Publisher> allPublishers = this.publisherService.getAllPublishers();
        model.addAttribute("publishers", allPublishers);
        return "publishers";
    }

    @RequestMapping(value = "/publishers", method = RequestMethod.POST)
    public String savePublisher(@Valid Publisher publisher, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "publisherForm";
        } else {
            this.publisherService.addPublisher(publisher);
            return "redirect:/publishers";
        }
    }

    @RequestMapping("/publisher")
    public String createPublisher(Model model) {
        model.addAttribute("publisher", new Publisher());
        return "publisherForm";
    }
}
