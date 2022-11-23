package com.library.booktask.service;

import com.library.booktask.mapper.BaseMapper;
import com.library.booktask.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract  class AbstractService<M extends BaseMapper> implements BaseService {

    protected final M mapper;

}
