package com.library.booktask.dto.book;

import com.library.booktask.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookCreateDto implements BaseDto {

    @NotNull(message= "Title doesn't be null")
    private String title;

    @NotNull(message= "Author doesn't be null")
    private String author;

    private String description;

}
