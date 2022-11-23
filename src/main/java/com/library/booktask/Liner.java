//package com.library.booktask;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.library.booktask.dto.book.BookCreateDto;
//import com.library.booktask.service.book.BookService;
//
//@Component
//public class Liner implements CommandLineRunner {
//
//    private final BookService bookService;
//
//    public Liner(BookService service){
//        this.bookService=service;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        List<BookCreateDto> data = new ArrayList<>();
//
//        data.add(new BookCreateDto("Crime and Punishment", "F. Dostoevsky", ""));
//        data.add(new BookCreateDto("Anna Karenina", "L. Tolstoy", ""));
//        data.add(new BookCreateDto("The Brothers Karamazov", "F. Dostoevsky", ""));
//        data.add(new BookCreateDto("War and Peace", "L. Tolstoy", ""));
//        data.add(new BookCreateDto("Dead Soulse", "N. Gogol", ""));
//
//        for (BookCreateDto d : data) {
//            bookService.create(d);
//        }
//
//
//    }
//
//
//
//}
