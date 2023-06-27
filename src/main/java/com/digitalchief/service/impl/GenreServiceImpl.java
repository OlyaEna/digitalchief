package com.digitalchief.service.impl;

import com.digitalchief.exceptions.ConstraintException;
import com.digitalchief.exceptions.NonUniqueException;
import com.digitalchief.exceptions.NotFoundException;
import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.model.dto.ProductDto;
import com.digitalchief.model.repository.GenreRepository;
import com.digitalchief.service.GenreService;
import com.digitalchief.service.ProductService;
import com.digitalchief.service.mapper.GenreMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreServiceImpl implements GenreService {
    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;
    private final ProductService productService;

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

    @Transactional
    @Override
    public void deleteGenreByName(String name) {
        GenreDto genre = findByName(name);
        List<ProductDto> products = productService.findAll();
        for (ProductDto product : products) {
            if (product.getGenres().contains(name) ){
                throw new ConstraintException("Could not execute statement. " + "'" + name + "'" + "  cannot be deleted.");
            } else {
                genreRepository.delete(genreMapper.toEntity(genre));
            }
        }
    }

    @Override
    public GenreDto findByName(String name) {
        GenreDto genre = genreMapper.toDto(genreRepository.findByName(name));
        if (genre == null) {
            throw new NotFoundException("Genre " + "'" + name + "'" + " does not exist. Try again.");
        }
        return genre;
    }

    @Override
    public GenreDto updateGenre(GenreDto genreDto, String name) {
        GenreDto genre = findByName(name);
        if (genre != null) {
            genre.setName(genreDto.getName());
            saveGenre(genre);
        }
        return genre;
    }
}
