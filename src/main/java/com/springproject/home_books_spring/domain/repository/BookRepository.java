package com.springproject.home_books_spring.domain.repository;

import com.springproject.home_books_spring.domain.entites.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Collection<Book> findByAuthorId(Integer idAuthor);

    Collection<Book> findByPublisherId(Integer idPublisher);

    Collection<Book> findByShelfRoomId(Integer idRoom);

    Collection<Book> findByShelfId(Integer idRoom);

    Optional<Book> findByStatusId(Integer idStatus);

    Collection<Book> findByStatusStatusTypeId(Integer idStatusType);

    Collection<Book> findBookByName(String name);
}
