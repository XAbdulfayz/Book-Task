package com.library.booktask.mapper;

import com.library.booktask.dto.BaseDto;
import com.library.booktask.dto.GenericDto;
import com.library.booktask.entity.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

/*
*    CD - Create Dto
*    UD - Update Dto
*    GD - Get Dto
*    E  - Entity
* */
public interface GenericMapper<CD extends BaseDto, UD extends GenericDto, GD extends GenericDto, E extends BaseEntity> extends BaseMapper {

    E fromCreateDTO(CD createDTO);

    E fromUpdateDTO(UD updateDTO, @MappingTarget E entity);

    GD toGetDTO(E entity);

    List<GD> toListDTO(List<E> entities);

}
