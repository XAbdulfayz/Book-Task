package com.library.booktask.service.book;

import com.library.booktask.dao.BookDaoImpl;
import com.library.booktask.dto.authors.AuthorDto;
import com.library.booktask.dto.authors.Task4Dto;
import com.library.booktask.dto.book.BookCreateDto;
import com.library.booktask.dto.book.BookGetDto;
import com.library.booktask.dto.book.BookUpdateDto;
import com.library.booktask.entity.book.Book;
import com.library.booktask.exception.NotFoundException;
import com.library.booktask.exception.validator.BadRequestException;
import com.library.booktask.mapper.book.BookMapper;
import com.library.booktask.service.AbstractService;
import com.library.booktask.service.GenericService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class BookService extends AbstractService<BookMapper> implements GenericService<BookCreateDto, BookUpdateDto, BookGetDto, Long> {


    public BookService(BookMapper mapper) {
        super(mapper);
    }

    /*
    * Задача этого сервиса добавить новую книгу
    *
    * 2. endpoint добавления новой книги в таблицу book
    * */
    @Override
    public BookGetDto create(BookCreateDto DTO) {

        Book book = mapper.fromCreateDTO(DTO);
        Book response = BookDaoImpl.getInstance().save(book);
        if (Objects.isNull(response)) {
            throw new BadRequestException("Произошла ошибка записи в базу данных");
        }
        return mapper.toGetDTO(response);
    }


    /*
    * Задача этого сервиса возвращает одну книгу по уникальному коду
    * */
    @Override
    public BookGetDto getByCode(Long id) {
        Book response = BookDaoImpl.getInstance().findById(id);
        if (Objects.isNull(response)) {
            throw new NotFoundException("книга не найдена");
        }
        return mapper.toGetDTO(response);
    }

    /*
    * Задача этого сервиса возвращает книги в обратном алфавитном порядке.
    *
    * 1. endpoint возвращающий список все книг, которые содержатся в таблице book,
    * отсортированный в обратном алфавитном порядке значения колонки book.title
    * */
    @Override
    public List<BookGetDto> getList() {
        List<Book> response = BookDaoImpl.getInstance().loadAllBookDescendingOrder();
        List<BookGetDto> bookGetDtos = mapper.toListDTO(response);
        return bookGetDtos;
    }

    /*
    *  Задача этого сервиса возвращает книги, сгруппированные по авторам.
    *
    *  3. endpoint возвращающий список всех книг, сгруппированных по автору
    *  книги(book.author)
    * */
    public List<AuthorDto> groupByAuthor() {
        List<Book> allBooks = BookDaoImpl.getInstance().loadAllBookDescendingOrder();
        List<String> allAuthors = allBooks.stream().map(r -> r.getAuthor()).distinct().toList();

        List<AuthorDto> response = new ArrayList<>();

        for (String author : allAuthors) {
            List<BookGetDto> authorsBook = new ArrayList<>();
            for (Book book : allBooks) {
                if (author.equals(book.getAuthor())) {
                    authorsBook.add(mapper.toGetDTO(book));
                }
            }
            AuthorDto authors = new AuthorDto(author, authorsBook);
            response.add(authors);
        }
        return response;
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
    public List<Task4Dto> getTask4Service(Character ch) {
        List<AuthorDto> authorBooks = groupByAuthor();
        List<Task4Dto> response = new ArrayList<>();

        for (AuthorDto authorBook : authorBooks) {
            Task4Dto result = new Task4Dto();
            int count = 0;
            for (BookGetDto book : authorBook.getBooks()) {
                for (int i = 0; i < book.getTitle().length(); i++) {
                    if (book.getTitle().toLowerCase(Locale.ROOT).charAt(i) == ch || book.getTitle().toUpperCase(Locale.ROOT).charAt(i) == ch) {
                        count++;
                    }
                }
            }
            if (count>0){
                result.setAuthorName(authorBook.getAuthorName());
                result.setNumber(count);
                response.add(result);
            }
        }

        return response.stream().sorted( (o1, o2) -> -o1.getNumber().compareTo(o2.getNumber())).collect(Collectors.toList());
    }

    @Override
    public BookGetDto update(BookUpdateDto DTO) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        return null;
    }
}
