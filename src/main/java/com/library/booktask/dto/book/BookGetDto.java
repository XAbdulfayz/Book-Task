package com.library.booktask.dto.book;

import com.library.booktask.dto.GenericDto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookGetDto extends GenericDto {

    private String title;

    private String author;

    private String description;

}
