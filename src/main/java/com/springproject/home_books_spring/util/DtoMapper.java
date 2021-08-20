package com.springproject.home_books_spring.util;

import com.springproject.home_books_spring.domain.dto.BookDto;
import com.springproject.home_books_spring.domain.dto.ShelfDto;
import com.springproject.home_books_spring.domain.entites.*;
import com.springproject.home_books_spring.domain.repository.StatusRepository;
import com.springproject.home_books_spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Component
public class DtoMapper {

    @Autowired
    RoomService roomService;

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    ShelfService shelfService;

    @Autowired
    StatusService statusService;

    @Autowired
    StatusTypeService statusTypeService;

    public Shelf fromShelfDto(ShelfDto shelfDto) {
        Shelf shelf = Shelf.builder()
                .id(shelfDto.getId())
                .letter(shelfDto.getLetter())
                .number(shelfDto.getNumber())
                .room(this.roomService.findRoomById(shelfDto.getIdRoom()))
                .build();
        return shelf;
    }

    public ShelfDto fromShelf(Shelf shelf) {
        ShelfDto shelfDto = ShelfDto.builder()
                .id(shelf.getId())
                .letter(shelf.getLetter())
                .number(shelf.getNumber())
                .idRoom(shelf.getRoom().getId())
                .build();
        return shelfDto;
    }

    public BookDto fromBook(Book book) {
        BookDto bookDto = BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .idAuthor(book.getAuthor().getId())
                .authorFirstName(book.getAuthor().getFirstName())
                .authorLastName(book.getAuthor().getLastName())
                .idPublisher(book.getPublisher().getId())
                .publisherName(book.getPublisher().getName())
                .idStatus(java.util.Optional.ofNullable(book.getStatus().getId()))
                .idStatusType(book.getStatus().getStatusType().getId())
                .statusTypeName(book.getStatus().getStatusType().getName())
                .comment(book.getStatus().getComment())
                .dateUp(book.getStatus().getDateUp())
                .idShelf(book.getShelf().getId())
                .shelfLetter(book.getShelf().getLetter())
                .shelfNumber(book.getShelf().getNumber())
                .idRoom(book.getShelf().getRoom().getId())
                .roomName(book.getShelf().getRoom().getName())
                .build();

        return bookDto;
    }

    public Book fromBookDto(BookDto bookDto) {
        Book book = Book.builder()
                .id(bookDto.getId())
                .name(bookDto.getName())
                .author(this.authorService
                        .findById(bookDto.getIdAuthor())
                        .orElse(Author.builder()
                                .firstName(bookDto.getAuthorFirstName())
                                .lastName(bookDto.getAuthorLastName())
                                .build()))
                .publisher(this.publisherService
                        .findById(bookDto.getIdPublisher())
                        .orElse(Publisher.builder()
                                .name(bookDto.getPublisherName())
                                .build()))
                .shelf(this.shelfService.getShelfById(bookDto.getIdShelf()))
                .status(Status.builder()
                        .dateUp(new Date(System.currentTimeMillis()))
                        .comment(bookDto.getComment())
                        .statusType(this.statusTypeService.getById(bookDto.getIdStatusType()))
                        .build())
                .build();
        return book;
    }
}
