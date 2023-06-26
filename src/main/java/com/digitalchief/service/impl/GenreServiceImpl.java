package com.digitalchief.service.impl;

import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.repository.GenreRepository;
import com.digitalchief.service.GenreService;
import com.digitalchief.service.mapper.GenreMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    public GenreDto saveGenre(GenreDto genreDto) {
        return genreMapper.toDto(genreRepository.save(genreMapper.toEntity(genreDto)));
    }

    public GenreDto createGenre(GenreDto genreDto) {
        GenreDto genre = genreMapper.toDto(genreRepository.findByName(genreDto.getName()));
        if (genre == null) {
            return saveGenre(genreDto);
        } else {
            throw new NonUniqueException("Genre is incorrect or already exists. Try again.");
        }
    }

    @Override
    public List<GenreDto> findAll() {
        return genreMapper.listToDto(genreRepository.findAll());
    }

    @Override
    public void deleteGenreByName(String name) {
        genreRepository.deleteGenreByName(name);
    }
}
