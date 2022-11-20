package com.library.booktask.repository;

import com.library.booktask.entity.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, UUID>, BaseRepository {

    Book findByCode(UUID code);

    @Query(value = "select * from Book order by title desc;", nativeQuery = true)
    List<Book> getAllDesc();


}
