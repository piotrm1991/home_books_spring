package com.springproject.home_books_spring.controllers;

import com.springproject.home_books_spring.domain.entites.Book;
import com.springproject.home_books_spring.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

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
}
