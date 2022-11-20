package com.library.booktask.dto.book;

import com.library.booktask.dto.GenericDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdateDto extends GenericDto {

    @NotNull(message= "Title doesn't be null")
    private String title;

    @NotNull(message= "Author doesn't be null")
    private String author;

    private String description;

}
