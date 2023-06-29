package com.digitalchief.service;

import com.digitalchief.model.dto.AuthorDto;
import com.digitalchief.model.dto.ParamProductDto;

import java.util.List;

public interface AuthorService {
    AuthorDto save(AuthorDto authorDto);

    AuthorDto create(AuthorDto authorDto);

    List<AuthorDto> findAll();

    void deleteByName(String name);

    AuthorDto findByName(String name);

    AuthorDto update(AuthorDto authorDto, String name);

    void insertIntoAuthorProduct(ParamProductDto authorProductDto);

}
