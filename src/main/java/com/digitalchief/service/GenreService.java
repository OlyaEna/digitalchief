package com.digitalchief.service;

import com.digitalchief.model.dto.GenreDto;

import java.util.List;

public interface GenreService {
    GenreDto saveGenre(GenreDto genreDto);

    GenreDto createGenre(GenreDto genreDto);

    List<GenreDto> findAll();

    void deleteGenreByName(String name);

}
