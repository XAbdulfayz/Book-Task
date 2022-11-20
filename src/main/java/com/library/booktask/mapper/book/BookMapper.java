package com.library.booktask.mapper.book;

import com.library.booktask.dto.book.BookCreateDto;
import com.library.booktask.dto.book.BookGetDto;
import com.library.booktask.dto.book.BookUpdateDto;
import com.library.booktask.entity.book.Book;
import com.library.booktask.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<BookCreateDto, BookUpdateDto, BookGetDto, Book> {

}
