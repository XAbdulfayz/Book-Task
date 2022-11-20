package com.library.booktask.service;

import com.library.booktask.mapper.BaseMapper;
import com.library.booktask.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract  class AbstractService<M extends BaseMapper, R extends BaseRepository> implements BaseService {

    protected final M mapper;
    protected final R repository;

}
