package com.digitalchief.service;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.ParamProductDto;

import java.util.List;

public interface GenreService {
    GenreDto saveGenre(GenreDto genreDto);

    GenreDto createGenre(GenreDto genreDto);

    List<GenreDto> findAll();

    void deleteGenreByName(String name);

    GenreDto findByName(String name);

    GenreDto updateGenre(GenreDto genreDto, String name);
    void insertIntoGenreProduct(ParamProductDto paramProductDto);

}
