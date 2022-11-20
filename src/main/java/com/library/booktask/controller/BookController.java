package com.library.booktask.controller;

import com.library.booktask.dto.authors.AuthorDto;
import com.library.booktask.dto.authors.Task4Dto;
import com.library.booktask.dto.book.BookCreateDto;
import com.library.booktask.dto.book.BookGetDto;
import com.library.booktask.response.Data;
import com.library.booktask.service.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/v1/book/*")
public class BookController extends AbstractController <BookService> {

    public BookController(BookService service) {
        super(service);
    }

    /*
     * Задача этого сервиса добавить новую книгу
     *
     * 2. endpoint добавления новой книги в таблицу book
     * */
    @PostMapping("create")
    public ResponseEntity<Data<BookGetDto>> create(@Valid @RequestBody BookCreateDto dto){
        BookGetDto bookGetDto = service.create(dto);
        return new ResponseEntity<>(new Data<>(bookGetDto), HttpStatus.OK);
    }

    /*
     * Задача этого сервиса возвращает одну книгу по уникальному коду
     * */
    @GetMapping("get/{code}")
    public ResponseEntity<Data<BookGetDto>> getByCode(@PathVariable UUID code){
        BookGetDto bookGetDto = service.getByCode(code);
        return new ResponseEntity<>(new Data<>(bookGetDto), HttpStatus.OK);
    }

    /*
     * Задача этого сервиса возвращает книги в обратном алфавитном порядке.
     *
     * 1. endpoint возвращающий список все книг, которые содержатся в таблице book,
     * отсортированный в обратном алфавитном порядке значения колонки book.title
     * */
    @GetMapping("get/list/desc")
    public ResponseEntity<Data<List<BookGetDto>>> getList(){
        List<BookGetDto> list = service.getList();
        return new ResponseEntity<>(new Data<>(list), HttpStatus.OK);
    }

    /*
     *  Задача этого сервиса возвращает книги, сгруппированные по авторам.
     *
     *  3. endpoint возвращающий список всех книг, сгруппированных по автору
     *  книги(book.author)
     * */
    @GetMapping("get/list/group-by-author")
    public ResponseEntity<Data<List<AuthorDto>>> groupByAuthor(){
        List<AuthorDto> list = service.groupByAuthor();
        return new ResponseEntity<>(new Data<>(list), HttpStatus.OK);
    }


    /*
     *  Это задание 4. Я назвал его Task4Dto, так как не смог найти имя для DTO.
     *
     *  4. endpoint принимающий в качестве параметра символ и возвращающий список из 10 авторов,
     *  в названии книг которых этот символ встречается наибольшее количество раз вместе с
     *  количеством вхождений этого символа во все названия книг автора.
     *  Регистр символа не имеет значения. Авторы, в названии книг которых символ отсутствует, не
     *  должны присутствовать в возвращаемом значении.
     *  Пример:
     *  Входной параметр: “а”
     *  Результат: [{L. Tolstoy, 7},{F. Dostoevsky, 4},{N. Gogol, 1}]
     * */
    @GetMapping("get/task4")
    public ResponseEntity<Data<List<Task4Dto>>> getTask4(){
        List<Task4Dto> response = service.getTask4Service();
        return new ResponseEntity<>(new Data<>(response), HttpStatus.OK);
    }

}
