package com.library.booktask.controller;

import com.library.booktask.service.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractController<S extends BaseService> implements BaseController{

    protected final S service;

}
