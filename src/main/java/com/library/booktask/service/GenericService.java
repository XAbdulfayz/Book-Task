package com.library.booktask.service;

import com.library.booktask.dto.BaseDto;
import com.library.booktask.dto.GenericDto;

import java.io.Serializable;
import java.util.List;

/*
 *    CD - Create Dto
 *    UD - Update Dto
 *    GD - Get Dto
 *    CODE - Data's code. UUID code
 * */
public interface GenericService<CD extends BaseDto, UD extends GenericDto, GD extends GenericDto, CODE extends Serializable> {

    GD create(CD DTO);

    GD update(UD DTO);

    GD getByCode(CODE code);

    List<GD> getList();

    Boolean delete(CODE code);

}
