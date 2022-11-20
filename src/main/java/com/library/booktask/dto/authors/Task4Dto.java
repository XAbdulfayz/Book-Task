package com.library.booktask.dto.authors;

import com.library.booktask.dto.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task4Dto implements BaseDto {

    private String authorName;
    private Integer number;

}
