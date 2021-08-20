package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.dto.PublisherDto;
import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.services.PublisherService;
import com.springproject.home_books_spring.util.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PublisherController {

    @Autowired
    PublisherService publisherService;

    @Autowired
    DtoMapper dtoMapper;

    @RequestMapping("/publishers")
    public String getAllPublishers(Model model) {
        List<Publisher> allPublishers = this.publisherService.getAllPublishers();
        List<PublisherDto> allPublishersDto = new ArrayList<>();
        allPublishers.stream().forEach(publisher -> {
            allPublishersDto.add(this.dtoMapper.fromPublisher(publisher));
        });
        model.addAttribute("publishers", allPublishersDto);
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

    @RequestMapping("/publisher/delete/{id}")
    public String deletePublisher(@PathVariable("id") Integer id) {
        this.publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }
}
