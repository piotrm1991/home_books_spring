package com.springproject.home_books_spring;

import com.springproject.home_books_spring.domain.entites.*;
import com.springproject.home_books_spring.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    AuthorService authorService;

    @Autowired
    PublisherService publisherService;

    @Autowired
    RoomService roomService;

    @Autowired
    ShelfService shelfService;

    @Autowired
    StatusTypeService statusTypeService;

    @Autowired
    BookService bookService;

    @Override
    public void run(String... args) throws Exception {

        this.init();


        Author build = Author.builder().firstName("test1").lastName("test2").build();
        authorService.addAuthor(build);
        Author build1 = Author.builder().firstName("test3").lastName("test5").build();
        authorService.addAuthor(build1);
        authorService.addAuthor(Author.builder().firstName("test4").lastName("test6").build());

        Publisher test1 = Publisher.builder().name("test1").build();
        publisherService.addPublisher(test1);
        publisherService.addPublisher(Publisher.builder().name("test2").build());
        publisherService.addPublisher(Publisher.builder().name("test3").build());

        Room room1 = Room.builder().name("test1").build();
        roomService.addRoom(room1);
        Room room2 = Room.builder().name("test2").build();
        roomService.addRoom(room2);
        Room room3 = Room.builder().name("test3").build();
        roomService.addRoom(room3);

        Shelf shelf1 = Shelf.builder().room(room1).letter("A").number(1).build();
        Shelf shelf2 = Shelf.builder().room(room1).letter("B").number(2).build();
        Shelf shelf3 = Shelf.builder().room(room2).letter("C").number(3).build();

        StatusType test11 = StatusType.builder().name("test1").build();
        statusTypeService.addStatusType(test11);
        statusTypeService.addStatusType(StatusType.builder().name("test2").build());



        shelfService.addShelf(shelf1);
        shelfService.addShelf(shelf2);
        shelfService.addShelf(shelf3);
        shelfService.addShelf(Shelf.builder().room(Room.builder().name("test4").build()).number(4).letter("D").build());
        shelfService.addShelf(Shelf.builder().room(room1).number(4).letter("D").build());

        Shelf shelf3ForBook = shelfService.getShelfById(3);

        Book book1 =
                Book.builder().name("Book1").author(build).publisher(test1).shelf(shelf3ForBook).status(Status.builder().statusType(test11).comment("Komentarz1").dateUp(new Date(System.currentTimeMillis())).build()).build();
        Book book2 =
                Book.builder().name("Book2").author(build1).publisher(test1).shelf(shelf3ForBook).status(Status.builder().statusType(test11).comment("Komentarz2").dateUp(new Date(System.currentTimeMillis())).build()).build();
        bookService.addBook(book1);
        bookService.addBook(book2);
    }

    private void init() {
        this.publisherService.prepareDefaultPublisher();
        this.authorService.prepareDefaultAuthor();
    }
}
