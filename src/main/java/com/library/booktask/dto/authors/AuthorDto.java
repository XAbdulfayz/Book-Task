package com.library.booktask.dto.authors;

import com.library.booktask.dto.BaseDto;
import com.library.booktask.dto.book.BookGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto implements BaseDto {

    private String authorName;

    private List<BookGetDto> books;

}
