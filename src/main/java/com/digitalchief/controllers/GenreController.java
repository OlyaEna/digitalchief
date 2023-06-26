package com.digitalchief.controllers;

import com.digitalchief.model.dto.GenreDto;
import com.digitalchief.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/genre")
public class GenreController {
    private final GenreService genreService;

    @GetMapping(path = "/all")
    public List<GenreDto> getAllGenres() {
        return genreService.findAll();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<String> createGenre(@RequestBody GenreDto genreDto) {
        GenreDto genre = genreService.createGenre(genreDto);
        return new ResponseEntity<>(genre.getName(), HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping(path = "/delete")
    public ResponseEntity<String> deleteGenre(@RequestBody GenreDto genreDto) {
        genreService.deleteGenreByName(genreDto.getName());
        return new ResponseEntity<>(genreDto.getName(), HttpStatus.OK);

    }
}
