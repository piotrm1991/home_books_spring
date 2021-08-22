package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.dto.AuthorDto;
import com.springproject.home_books_spring.domain.entites.Author;
import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.services.AuthorService;
import com.springproject.home_books_spring.util.DtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @Autowired
    DtoMapper dtoMapper;

    @RequestMapping("/authors")
    public String getAllAuthors(Model model) {
        List<Author> allAuthors = this.authorService.getAllAuthors();
        List<AuthorDto> allAuthorsDto = new ArrayList<>();
        allAuthors.stream().forEach(author -> {
            allAuthorsDto.add(this.dtoMapper.fromAuthor(author));
        });
        model.addAttribute("authors", allAuthorsDto);
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

    @RequestMapping("/createAuthor")
    public String createAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "authorForm";
    }

    @RequestMapping("/author/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id) {
        this.authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @RequestMapping("/editAuthor")
    public String editAuthor(@RequestParam("authorId") Integer id, Model model) {
        Author author = this.authorService.findById(id).get();
        model.addAttribute("author", author);
        return "authorForm";
    }
}
