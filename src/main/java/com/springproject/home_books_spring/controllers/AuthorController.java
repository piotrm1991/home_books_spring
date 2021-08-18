package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @RequestMapping("/authors")
    public String getAllAuthors(Model model) {
        List<Author> allAuthors = this.authorService.getAllAuthors();
        model.addAttribute("authors", allAuthors);
        return "authors";
    }

    @RequestMapping(value = "/authors", method = RequestMethod.POST)
    public String saveAuthor(@Valid Author author, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "authorForm";
        } else {
            this.authorService.addAuthor(author);
            return "redirect:/authors";
        }
    }

    @RequestMapping("/author")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }
}
