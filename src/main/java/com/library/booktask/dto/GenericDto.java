package com.library.booktask.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GenericDto implements BaseDto{
    private UUID code;
}
