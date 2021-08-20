package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.dto.BookDto;
import com.springproject.home_books_spring.domain.dto.ShelfDto;
import com.springproject.home_books_spring.domain.entites.Book;
import com.springproject.home_books_spring.domain.entites.Publisher;
import com.springproject.home_books_spring.services.*;
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
import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    DtoMapper dtoMapper;

    @Autowired
    ShelfService shelfService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    StatusTypeService statusTypeService;

    @RequestMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> allBooks = this.bookService.getAllBooks();
        model.addAttribute("books", allBooks);
        return "books";
    }

    @RequestMapping("/books/author/{id}")
    public String getBooksByAuthor(@PathVariable("id") Integer id, Model model) {
        List<Book> booksByAuthorId = this.bookService.getBooksByAuthorId(id);
        model.addAttribute("books", booksByAuthorId);
        return "books";
    }

    @RequestMapping("/books/publisher/{id}")
    public String getBooksByPublisher(@PathVariable("id") Integer id, Model model) {
        List<Book> booksByPublisherId = this.bookService.getBooksByPublisherId(id);
        model.addAttribute("books", booksByPublisherId);
        return "books";
    }

    @RequestMapping("/books/room/{id}")
    public String getBooksByRoom(@PathVariable("id") Integer id, Model model) {
        List<Book> booksByRoomId = this.bookService.getBooksByRoomId(id);
        model.addAttribute("books", booksByRoomId);
        return "books";
    }

    @RequestMapping("/books/shelf/{id}")
    public String getBooksByShelf(@PathVariable("id") Integer id, Model model) {
        List<Book> booksByShelfId = this.bookService.getBooksByShelfId(id);
        model.addAttribute("books", booksByShelfId);
        return "books";
    }
    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String saveBook(@Valid BookDto bookDto, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            System.out.println("There were some errors!");
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getObjectName() + error.getDefaultMessage()));
            return "bookForm";
        } else {
            this.bookService.addBook(this.dtoMapper.fromBookDto(bookDto));
            return "redirect:/books";
        }
    }

    @RequestMapping("/book")
    public String createBook(Model model) {
        model.addAttribute("book", new BookDto());
        model.addAttribute("shelves", this.shelfService.getAllShelves());
        model.addAttribute("authors", this.authorService.getAllAuthors());
        model.addAttribute("publishers", this.publisherService.getAllPublishers());
        model.addAttribute("statusTypes", this.statusTypeService.getAllStatusTypes());
        return "bookForm";
    }
}
